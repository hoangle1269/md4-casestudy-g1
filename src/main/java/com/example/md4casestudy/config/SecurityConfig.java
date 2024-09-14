package com.example.md4casestudy.config;

import com.example.md4casestudy.controller.CustomSuccessHandle;
import com.example.md4casestudy.model.ENUM.ROLE;
import com.example.md4casestudy.service.appUser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AppUserService appUserService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(appUserService);
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return authenticationProvider;
    }

    @Bean
    public CustomSuccessHandle customSuccessHandle() {
        return new CustomSuccessHandle();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
//                    .requestMatchers("/login", "/register").permitAll()
                                .requestMatchers("/css**", "/images**", "/js**").permitAll()

                                .requestMatchers("/admin**").hasAuthority(ROLE.ROLE_ADMIN.getRoleName())
                                .requestMatchers("/lecturer**").hasAuthority(ROLE.ROLE_LECTURER.getRoleName())
                                .requestMatchers("/student**").hasAuthority(ROLE.ROLE_STUDENT.getRoleName())
                                .requestMatchers("/staff**").hasAuthority(ROLE.ROLE_STAFF.getRoleName())
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
//                    .loginPage("/login")
                                .permitAll()
                )
                .logout(logout -> logout
                        .permitAll()
                );

        return http.build();
    }


}