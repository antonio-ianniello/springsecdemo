package com.ianniello.springsecuritydemo.controller;

import com.ianniello.springsecuritydemo.advisor.GlobalExceptionHandlerController;
import com.ianniello.springsecuritydemo.dto.GeneralResponseDto;
import com.ianniello.springsecuritydemo.enums.StudentStatusEnum;
import com.ianniello.springsecuritydemo.exception.CustomException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

/**
 * IndexController
 * <p>
 * basically in case of error default path of redirect will be /error, so in this class
 * that path is configured to return a custom GenerlResponseDto instead of default response
 * managed by Spring
 * <p>
 * errorTriggered method used to simulate a CustomException handled by GlobalExceptionHandlerController
 *
 * @author Ianniello Antonio
 * @version 1.0.3
 * @see GlobalExceptionHandlerController
 * @since 2024-10-28
 */
@Slf4j
@RestController
public class IndexController implements ErrorController {
    private static final String ERROR_PATH = "/error";
    private static final String ERROR_PATH_TRIGGERED = "/triggered";
    public static final String HOME_PATH = "/";

    @RequestMapping(value = ERROR_PATH)
    public ResponseEntity<GeneralResponseDto> handleError(HttpServletRequest request) {
        int status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE) != null ? Integer.parseInt(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString()) : 500;
        String message = request.getAttribute(RequestDispatcher.ERROR_MESSAGE) != null ? request.getAttribute(RequestDispatcher.ERROR_MESSAGE).toString() : "error page called";
        GeneralResponseDto customError = new GeneralResponseDto(StudentStatusEnum.KO, status, message);
        log.info("error with status code: {} message: {}", status, message);
        return ResponseEntity.status(HttpStatus.valueOf(status)).body(customError);
    }

    @RequestMapping(value = ERROR_PATH_TRIGGERED)
    public ResponseEntity<GeneralResponseDto> errorTriggered() {

        throw new CustomException(500, ERROR_PATH_TRIGGERED);
    }

    @GetMapping(HOME_PATH)
    public ResponseEntity<GeneralResponseDto> studentHome() {

        return ok(GeneralResponseDto.ok);
    }


    @GetMapping({"/ko"})
    public ResponseEntity<GeneralResponseDto> getKo() {

        return ok(GeneralResponseDto.failure);
    }
}
