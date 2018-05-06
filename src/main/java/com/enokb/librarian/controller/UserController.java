package com.enokb.librarian.controller;

import com.enokb.librarian.config.exception.InvalidParamException;
import com.enokb.librarian.config.exception.NeedAuthenticationException;
import com.enokb.librarian.dto.ResponseDto;
import com.enokb.librarian.dto.user.OperatorBookItemDto;
import com.enokb.librarian.security.Authentication;
import com.enokb.librarian.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @ApiOperation(value = "获取用户借阅图书", produces = "application/json")
    @GetMapping("/borrowing")
    public ResponseEntity<ResponseDto> userBorrowing() {
        String userId = authentication.getUserId();
        if (StringUtils.isEmpty(userId)) {
            throw new NeedAuthenticationException();
        }
        return new ResponseEntity<ResponseDto>(ResponseDto.ok(iUserService
                .borrowing(userId)), HttpStatus.OK);
    }

    @ApiOperation(value = "续借图书", produces = "application/json")
    @PutMapping("/renewal")
    public ResponseEntity<ResponseDto> operatorRenewal(@Valid @RequestBody OperatorBookItemDto request, BindingResult bindingResult ) {
        if (bindingResult.hasErrors()) {
            throw new InvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        String userId = authentication.getUserId();
        if (StringUtils.isEmpty(userId)) {
            throw new NeedAuthenticationException();
        }
        return new ResponseEntity<ResponseDto>(ResponseDto.ok(iUserService
                .renewal(userId, request.getBookItemId())), HttpStatus.OK);
    }

    @ApiOperation(value = "预约图书", produces = "application/json")
    @PostMapping("/appointment")
    public ResponseEntity<ResponseDto> appointment(@Valid @RequestBody OperatorBookItemDto request, BindingResult bindingResult ) {
        if (bindingResult.hasErrors()) {
            throw new InvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        String userId = authentication.getUserId();
        if (StringUtils.isEmpty(userId)) {
            throw new NeedAuthenticationException();
        }
        return new ResponseEntity<ResponseDto>(ResponseDto.ok(iUserService
                .appointment(userId, request.getBookItemId())), HttpStatus.OK);
    }
}
