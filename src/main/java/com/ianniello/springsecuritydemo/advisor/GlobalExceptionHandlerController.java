package com.ianniello.springsecuritydemo.advisor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ianniello.springsecuritydemo.dto.GeneralResponseDto;
import com.ianniello.springsecuritydemo.enums.StudentStatusEnum;
import com.ianniello.springsecuritydemo.exception.CustomException;
import com.ianniello.springsecuritydemo.exception.NotAllowAccess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

/**
 * GlobalExceptionHandlerController
 *
 * <p>
 * Exception Handler Class
 * </p>
 *
 * @author Ianniello Antonio
 * @version 1.0
 * @since 2024-10-28
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandlerController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GeneralResponseDto> handleCustomException(Exception e) throws IOException {
        log.error("HttpStatus {} will be returned | Exception Type: GeneralException | Details: {}", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        return new ResponseEntity<>(new GeneralResponseDto<>(StudentStatusEnum.KO, -500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotAllowAccess.class)
    public ResponseEntity<GeneralResponseDto> handleCustomException(NotAllowAccess e) throws IOException {
        log.error("HttpStatus {} will be returned | Exception Type: Not allow access | Details: {}", HttpStatus.FORBIDDEN, e.getMessage());
        return new ResponseEntity<>(new GeneralResponseDto<>(StudentStatusEnum.KO, e.getCode(), e.getMessage()), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<GeneralResponseDto> handleCustomException(JsonProcessingException e) throws IOException {
        log.error("HttpStatus {} will be returned | Exception Type: JsonProcessingException | Details: {}", HttpStatus.CONFLICT, e.getMessage());
        return new ResponseEntity<>(new GeneralResponseDto<>(StudentStatusEnum.KO, 409, e.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<GeneralResponseDto> handleCustomException(IOException e) throws IOException {
        log.error("HttpStatus {} will be returned | Exception Type: IOException | Details: {}", HttpStatus.CONFLICT, e.getMessage());
        return new ResponseEntity<>(new GeneralResponseDto<>(StudentStatusEnum.KO, 409, e.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<GeneralResponseDto> handleCustomException(CustomException e) throws IOException {
        log.error("HttpStatus {} will be returned | Exception Type: CustomException | Details: {}", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        return new ResponseEntity<>(new GeneralResponseDto<>(StudentStatusEnum.KO, e.getCode(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
