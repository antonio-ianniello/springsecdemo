package com.ianniello.springsecuritydemo.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * CustomAccessDeniedHandler
 * <p>
 * Custom management of AccessDeniedHandler
 *
 * @author Ianniello Antonio
 * @version 1.0.3
 * @see SecurityConfig
 * @since 2024-10-28
 */
@Slf4j
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        //response.setContentType("application/json");
        //response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        //response.getWriter().write("{\"error\": \"Access Denied\"}");
        log.warn("WARN: {} {}", HttpServletResponse.SC_FORBIDDEN, request.getRequestURI());
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");

    }
}
