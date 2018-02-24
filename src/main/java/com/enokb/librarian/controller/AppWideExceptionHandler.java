/**  
* @Title: AppWideExceptionHandler.java  
* @Package com.eyee.esdata.controller  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Ksewen  
* @date 2017年12月22日  
*/
package com.enokb.librarian.controller;

import java.io.FileNotFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ClassName: AppWideExceptionHandler
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Ksewen
 * @date 2017年12月22日
 * 
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@ControllerAdvice
public class AppWideExceptionHandler {

}
