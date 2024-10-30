package com.ianniello.springsecuritydemo.dto;

import com.ianniello.springsecuritydemo.enums.StudentStatusEnum;
import lombok.Data;

/**
 * GeneralResponseDto
 *
 * <p>
 * This represents general dto of the response, contains info about status [ OK ] or [ KO ]
 * in data will be inserted the real information about what must be returned, it could be null
 * Error field contains error message and code when an error occurred
 * </p>
 *
 * @author Ianniello Antonio
 * @version 1.0
 * @since 2024-10-28
 */
@Data
public class GeneralResponseDto<T> {

    public final static GeneralResponseDto ok = new GeneralResponseDto(StudentStatusEnum.OK);
    public final static GeneralResponseDto failure = new GeneralResponseDto(StudentStatusEnum.KO);

    private StudentStatusEnum status;
    private T data;
    private GeneralErrorResponseDto error;

    public GeneralResponseDto() {
        this.status = StudentStatusEnum.OK;
    }

    public GeneralResponseDto(T data) {
        this.status = StudentStatusEnum.OK;
        this.data = data;
    }

    public GeneralResponseDto(StudentStatusEnum status) {
        this.status = status;
    }

    public GeneralResponseDto(StudentStatusEnum status, int code, String message) {
        this.status = status;
        this.error = new GeneralErrorResponseDto(code, message);
    }
}
