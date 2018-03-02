package com.enokb.librarian.controller;

import com.enokb.librarian.config.exception.InvalidParamException;
import com.enokb.librarian.domain.AdminDomain;
import com.enokb.librarian.dto.Admin.AdminDto;
import com.enokb.librarian.dto.Admin.AdminResultDto;
import com.enokb.librarian.dto.IdDto;
import com.enokb.librarian.service.IAdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018-03-02 17:51
 **/
@RestController
@RequestMapping("/admin")
public class AdminController extends AppWideExceptionHandler {

    @Autowired
    private IAdminService iAdminService;

    @ApiOperation(value = "新增管理员", produces = "application/json")
    @PostMapping
    public ResponseEntity<Integer> insertAdmin(@Valid @RequestBody AdminDto request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        AdminDomain admin = new AdminDomain();
        BeanUtils.copyProperties(request, admin);
        return new ResponseEntity<Integer>(iAdminService.insert(admin),  HttpStatus.OK);
    }

    @ApiOperation(value = "查询管理员", produces = "application/json")
    @GetMapping
    public ResponseEntity<AdminResultDto> queryAdmin(@Valid @RequestBody IdDto request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        AdminResultDto admin = new AdminResultDto();
        BeanUtils.copyProperties(iAdminService.selectById(request.getId()), admin);
        return new ResponseEntity<AdminResultDto>(admin, HttpStatus.OK);
    }
}
