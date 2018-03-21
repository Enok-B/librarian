/**
 * @Title: AppWideExceptionHandler.java
 * @Package com.eyee.esdata.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Ksewen
 * @date 2017年12月22日
 */
package com.enokb.librarian.controller;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.enokb.librarian.config.exception.InvalidParamException;
import com.enokb.librarian.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

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
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDto<String> handleValidationException(ConstraintViolationException e) {
        for (ConstraintViolation<?> s : e.getConstraintViolations()) {
            return new ResponseDto<String>(s.getMessage());
        }
        return new ResponseDto<String>(ERROR_INVALIDPARAM_MESSAGE);
    }

    @ExceptionHandler(InvalidParamException.class)
    public ResponseEntity<ResponseDto<String>> invalidParamHandler(InvalidParamException e) {
        return new ResponseEntity<ResponseDto<String>>(new ResponseDto<>(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
