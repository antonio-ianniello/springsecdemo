package com.ianniello.springsecuritydemo.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
/**
 * CustomAuthenticationEntryPoint
 * <p>
 * Custom management of AuthenticationEntryPoint
 *
 * @author Ianniello Antonio
 * @version 1.0.3
 * @see SecurityConfig
 * @since 2024-10-28
 */
@Slf4j
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        //response.setContentType("application/json");
        //response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        //response.getWriter().write("{\"error\": \"Unauthorised Access\"}");
        log.warn("WARN: {} {}",HttpServletResponse.SC_UNAUTHORIZED,request.getRequestURI());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Unauthorized");
    }
}
