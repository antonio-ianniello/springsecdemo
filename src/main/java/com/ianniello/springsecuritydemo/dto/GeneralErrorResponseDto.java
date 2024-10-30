package com.ianniello.springsecuritydemo.dto;

import lombok.Data;

/**
 * GeneralErrorResponseDto
 *
 * <p>
 * This represents general error of the response, contains info about code and a message of error
 * </p>
 *
 * @author Ianniello Antonio
 * @version 1.0
 * @since 2024-10-28
 */
@Data
public class GeneralErrorResponseDto {

    private int code;
    private String message;

    public GeneralErrorResponseDto(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
