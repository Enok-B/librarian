package com.enokb.librarian.controller;

import com.enokb.librarian.config.exception.NeedAuthenticationException;
import com.enokb.librarian.dto.ResponseDto;
import com.enokb.librarian.security.Authentication;
import com.enokb.librarian.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018-03-19 16:12
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Authentication authentication;

    @Autowired
    private IUserService iUserService;

    @ApiOperation(value = "获取用户信息", produces = "application/json")
    @GetMapping("/info")
    public ResponseEntity<ResponseDto> userInfo() {
        String identity = authentication.getUsername();
        if (StringUtils.isEmpty(identity)) {
            throw new NeedAuthenticationException();
        }
        return new ResponseEntity<ResponseDto>(ResponseDto.ok(iUserService
                .userInfo(identity)), HttpStatus.OK);
    }

    @ApiOperation(value = "获取用户信息", produces = "application/json")
    @GetMapping("/borrowing")
    public ResponseEntity<ResponseDto> userBorrowing() {
        String userId = authentication.getUserId();
        if (StringUtils.isEmpty(userId)) {
            throw new NeedAuthenticationException();
        }
        return new ResponseEntity<ResponseDto>(ResponseDto.ok(iUserService
                .borrowing(userId)), HttpStatus.OK);
    }
}
