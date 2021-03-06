/**
 * @Title: AppWideExceptionHandler.java
 * @Package com.eyee.esdata.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Ksewen
 * @date 2017年12月22日
 */
package com.enokb.librarian.controller;

import com.enokb.librarian.config.exception.*;
import com.enokb.librarian.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * @author Ksewen
 * @ClassName: AppWideExceptionHandler
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2017年12月22日
 */

@ControllerAdvice
public class AppWideExceptionHandler {

    private static final String ERROR_INVALIDPARAM_MESSAGE = "invalid params";

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity handleValidationException(ConstraintViolationException e) {
        for (ConstraintViolation<?> s : e.getConstraintViolations()) {
            return new ResponseEntity(ResponseDto.invalidParam(s.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(ResponseDto.invalidParam(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidParamException.class)
    public ResponseEntity invalidParamHandler(InvalidParamException e) {
        return new ResponseEntity(ResponseDto.invalidParam(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity resourceNotFoundHandler(ResourceNotFoundException e) {
        return new ResponseEntity(ResponseDto.notFound(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OverQuotaException.class)
    public ResponseEntity overQuotaHandler(OverQuotaException e) {
        return new ResponseEntity(ResponseDto.badRequest(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IncorrectStatusException.class)
    public ResponseEntity incorrectStatusHandler(IncorrectStatusException e) {
        return new ResponseEntity(ResponseDto.badRequest(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotAppointmentException.class)
    public ResponseEntity notAppointmentHandler(NotAppointmentException e) {
        return new ResponseEntity(ResponseDto.badRequest(e.getMessage()), HttpStatus.CONFLICT);
    }
}
