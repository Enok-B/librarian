package com.enokb.librarian.controller;

import com.enokb.librarian.config.constant.ResponseCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018-02-24 16:25
 **/
@RestController
@RequestMapping("/")
public class HelloController {
    @ApiOperation(value = "首页", produces = "application/json")
    @GetMapping
    public ResponseEntity<String> welCome() {
        return new ResponseEntity<String>(
                "Welcome from librarian @Enok", HttpStatus.OK);
    }
}
