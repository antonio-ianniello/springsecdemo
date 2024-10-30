package com.ianniello.springsecuritydemo.exception;

import lombok.Data;

/**
 * CustomException
 *
 * <p>
 * CustomException will be used to handle exception in project,
 * usually other exceptions extends this class
 * </p>
 *
 * @author Ianniello Antonio
 * @version 1.0
 * @since 2024-10-28
 */
@Data
public class CustomException extends RuntimeException {

    private Object data;
    int code = -1;

    public CustomException(int code, String message) {
        super(message);
        this.code = code;
    }

    public CustomException(int code, String message, Object data) {
        super(message);
        this.data = data;
        this.code = code;
    }

}
