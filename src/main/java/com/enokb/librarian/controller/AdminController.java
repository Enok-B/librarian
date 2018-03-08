package com.enokb.librarian.controller;

import com.enokb.librarian.config.exception.InvalidParamException;
import com.enokb.librarian.domain.AdminDomain;
import com.enokb.librarian.dto.Admin.AdminDto;
import com.enokb.librarian.dto.Admin.AdminResultDto;
import com.enokb.librarian.dto.ResponseDto;
import com.enokb.librarian.service.IAdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018-03-02 17:51
 **/
@RestController
@RequestMapping("/admin")
@Validated
public class AdminController extends AppWideExceptionHandler {

    @Autowired
    private IAdminService iAdminService;

    @ApiOperation(value = "新增管理员", produces = "application/json")
    @PostMapping(value = "/user")
    public ResponseEntity<ResponseDto<Integer>> insertAdmin(@Valid @RequestBody AdminDto request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        AdminDomain admin = new AdminDomain();
        BeanUtils.copyProperties(request, admin);
        return new ResponseEntity<ResponseDto<Integer>>(new ResponseDto<>(iAdminService.insert(admin)), HttpStatus.OK);
    }

    @ApiOperation(value = "查询管理员", produces = "application/json")
    @GetMapping("/user")
    public ResponseEntity<ResponseDto<AdminResultDto>> queryAdmin(@NotNull(message = "{admin.id.null}") @RequestParam Integer id) {
        AdminResultDto admin = new AdminResultDto();
        BeanUtils.copyProperties(iAdminService.selectById(id), admin);
        return new ResponseEntity<ResponseDto<AdminResultDto>>(new ResponseDto<>(admin), HttpStatus.OK);
    }
}
