package com.enokb.librarian.controller;

import com.enokb.librarian.config.exception.InvalidParamException;
import com.enokb.librarian.dto.ResponseDto;
import com.enokb.librarian.dto.user.UserDto;
import com.enokb.librarian.model.UserRegisterModel;
import com.enokb.librarian.service.IAuthService;
import com.enokb.librarian.service.IUserService;
import com.enokb.librarian.utils.BeanMapperUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018-03-19 16:13
 **/
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IAuthService iAuthService;

    @ApiOperation(value = "注册用户", produces = "application/json")
    @PostMapping("/register")
    //FIXME: 返回boolean会报json转换错误
    public ResponseEntity<ResponseDto> register(@Valid @RequestBody UserDto request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        return new ResponseEntity<ResponseDto>(ResponseDto.ok(iAuthService.register(BeanMapperUtil
                .createAndCopyProperties(request, UserRegisterModel.class))), HttpStatus.OK);
    }

    @ApiOperation(value = "登录", produces = "application/json")
    @PostMapping("/login")
    public ResponseEntity<ResponseDto> login(@Valid @RequestBody UserDto request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        return new ResponseEntity<ResponseDto>(ResponseDto.ok(iAuthService
                .login(request.getStudentId(), request.getPassword())), HttpStatus.OK);
    }
}
