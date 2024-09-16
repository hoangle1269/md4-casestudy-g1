package com.example.md4casestudy.config.security;

import com.example.md4casestudy.model.User;
import com.example.md4casestudy.service.appUser.AppUserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private AppUserService appUserService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String username = authentication.getName();
        User user = appUserService.findByEmail(username);
        System.out.println(username);
        System.out.println("////////////////////////////////////");
        System.out.println(user);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        } else {

        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
