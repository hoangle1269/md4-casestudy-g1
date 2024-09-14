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
        // Lấy quyền của người dùng hiện tại
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String redirectUrl = "/";

        // Xác định trang chuyển hướng dựa trên vai trò của người dùng
        if (authorities.stream().anyMatch(auth -> auth.getAuthority().equals("admin"))) {
            redirectUrl = "/admin";
        } else if (authorities.stream().anyMatch(auth -> auth.getAuthority().equals("lecturer"))) {
            redirectUrl = "/lecturer";
        } else if (authorities.stream().anyMatch(auth -> auth.getAuthority().equals("student"))) {
            redirectUrl = "/student";
        } else if (authorities.stream().anyMatch(auth -> auth.getAuthority().equals("staff"))) {
            redirectUrl = "/staff";
        }

        // Chuyển hướng người dùng đến URL phù hợp
        response.sendRedirect(redirectUrl);
    }
}
