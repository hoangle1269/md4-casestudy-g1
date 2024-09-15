package com.example.md4casestudy.config.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Collection;

public class CustomSuccessHandle implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String redirectUrl = "/";

        if (authorities.stream().anyMatch(auth -> auth.getAuthority().equals("admin"))) {
            redirectUrl = "/admin";
        } else if (authorities.stream().anyMatch(auth -> auth.getAuthority().equals("lecturer"))) {
            redirectUrl = "/lecturer";
        } else if (authorities.stream().anyMatch(auth -> auth.getAuthority().equals("student"))) {
            redirectUrl = "/student";
        } else if (authorities.stream().anyMatch(auth -> auth.getAuthority().equals("staff"))) {
            redirectUrl = "/staff";
        }

        response.sendRedirect(redirectUrl);
    }
}