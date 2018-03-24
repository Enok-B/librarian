package com.enokb.librarian.controller;

import com.enokb.librarian.config.exception.InvalidParamException;
import com.enokb.librarian.dto.ResponseDto;
import com.enokb.librarian.dto.auth.RegisterDto;
import com.enokb.librarian.model.UserRegisterModel;
import com.enokb.librarian.service.IUserService;
import com.enokb.librarian.utils.BeanMapperUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private IUserService iUserService;

    @ApiOperation(value = "新增管理员", produces = "application/json")
    @PostMapping("/add")
    public ResponseEntity<ResponseDto> register(@Valid @RequestBody RegisterDto request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        return new ResponseEntity<ResponseDto>(ResponseDto.ok(iUserService.newAdmin(BeanMapperUtil
                .createAndCopyProperties(request, UserRegisterModel.class))), HttpStatus.OK);
    }
}
