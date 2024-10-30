package com.ianniello.springsecuritydemo.exception;

/**
 * NotAllowAccess
 *
 * <p>
 * Exception triggered when user is not authorised to access a resource
 * </p>
 *
 * @author Ianniello Antonio
 * @version 1.0
 * @since 2024-10-28
 */
public class NotAllowAccess extends CustomException {

    public NotAllowAccess(String message) {
        super(-409, message);
    }

    public NotAllowAccess(String message, Object data) {
        super(-409, message, data);
    }
}
