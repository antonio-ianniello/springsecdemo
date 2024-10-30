package com.ianniello.springsecuritydemo.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.util.Enumeration;

/**
 * MonitoringUtils
 *
 * <p>
 * Utils can be used for a quick examination of cookies and header's values
 * </p>
 *
 * @author Ianniello Antonio
 * @version 1.0
 * @since 2024-10-28
 */
@Slf4j
public class MonitoringUtils {

    public static final String SEGMENTS = "---------------------------";

    public static void monitoringRequest(HttpServletRequest request) {
        log.info("{} START MONITORING REQUEST {}", SEGMENTS, SEGMENTS);
        log.info("PATH: {}", request.getRequestURI());
        log.info("METHOD: {}", request.getMethod());
        log.info("AUTH TYPE: {}", request.getAuthType());
        log.info("{} COOKIES {}", SEGMENTS, SEGMENTS);
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                log.info("name: {}", cookie.getName());
                log.info("value: {}", cookie.getValue());
                log.info("path: {}", cookie.getPath());
                log.info("domain: {}", cookie.getDomain());
                log.info("isHttpOnly: {}", cookie.isHttpOnly());
                log.info("secure: {}", cookie.getSecure());
                log.info("maxAge: {}", cookie.getMaxAge());
                log.info(SEGMENTS);
            }
        }

        log.info("{} HEADERS {}", SEGMENTS, SEGMENTS);
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                String headerValue = request.getHeader(headerName) != null ? request.getHeader(headerName) : "";
                log.info("headerName: {} headerValue: {}", headerName, headerValue);
            }
        }
        log.info("{} END MONITORING REQUEST {}", SEGMENTS, SEGMENTS);

    }
}
