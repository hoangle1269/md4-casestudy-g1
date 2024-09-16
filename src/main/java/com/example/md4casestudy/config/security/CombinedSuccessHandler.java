package com.example.md4casestudy.config.security;

import com.example.md4casestudy.model.User;
import com.example.md4casestudy.service.appUser.AppUserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class CombinedSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(CombinedSuccessHandler.class);

    @Autowired
    private AppUserService appUserService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {


        String username = authentication.getName();
        logger.info("User '{}' authenticated successfully", username);

        User user = appUserService.findByEmail(username);
        if (user != null) {
            HttpSession session = request.getSession();

            session.removeAttribute("user");

            session.setAttribute("user", user);
            Object value = session.getAttribute("user");

            System.out.println(value);
            logger.info("User '{}' added to session", username);
        } else {
            logger.warn("User '{}' not found", username);
        }


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

        logger.info("Redirecting user '{}' to '{}'", username, redirectUrl);
        response.sendRedirect(redirectUrl);
    }
}
