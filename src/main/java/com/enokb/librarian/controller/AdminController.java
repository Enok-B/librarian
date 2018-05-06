package com.enokb.librarian.controller;

import com.enokb.librarian.config.exception.InvalidParamException;
import com.enokb.librarian.config.exception.NeedAuthenticationException;
import com.enokb.librarian.dto.ResponseDto;
import com.enokb.librarian.dto.admin.AdminAddDto;
import com.enokb.librarian.dto.admin.BookEntryDto;
import com.enokb.librarian.dto.admin.OperatorBorrowDto;
import com.enokb.librarian.dto.user.OperatorBookItemDto;
import com.enokb.librarian.model.BookEntryModel;
import com.enokb.librarian.model.UserRegisterModel;
import com.enokb.librarian.security.Authentication;
import com.enokb.librarian.service.IAdminService;
import com.enokb.librarian.service.IBookService;
import com.enokb.librarian.service.IUserService;
import com.enokb.librarian.utils.BeanMapperUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private Authentication authentication;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IBookService iBookService;

    @Autowired
    private IAdminService iAdminService;

    @ApiOperation(value = "新增管理员", produces = "application/json")
    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addAdmin(@Valid @RequestBody AdminAddDto request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        return new ResponseEntity<ResponseDto>(ResponseDto.ok(iUserService.newAdmin(BeanMapperUtil
                .createAndCopyProperties(request, UserRegisterModel.class))), HttpStatus.OK);
    }

    @ApiOperation(value = "录入图书", produces = "application/json")
    @PostMapping("/entryBook")
    public ResponseEntity<ResponseDto> entryBook(@Valid @RequestBody BookEntryDto request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        return new ResponseEntity<ResponseDto>(ResponseDto.ok(iBookService.entryBook(BeanMapperUtil
                        .createAndCopyProperties(request, BookEntryModel.class), authentication.getUserId(),
                request.getArea(), request.getStatus())), HttpStatus.OK);
    }

    @ApiOperation(value = "借出图书", produces = "application/json")
    @PostMapping("/operatorBorrow")
    public ResponseEntity<ResponseDto> operatorBorrow(@Valid @RequestBody OperatorBorrowDto request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        String userId = authentication.getUserId();
        if (StringUtils.isEmpty(userId)) {
            throw new NeedAuthenticationException();
        }
        return new ResponseEntity<ResponseDto>(ResponseDto.ok(iAdminService.borrow(request.getIdentity(), request.getBookItemId()
                , userId)), HttpStatus.OK);
    }

    @ApiOperation(value = "归还图书", produces = "application/json")
    @PutMapping("/operatorRevert")
    public ResponseEntity<ResponseDto> operatorRevert(@Valid @RequestBody OperatorBorrowDto request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        String userId = authentication.getUserId();
        if (StringUtils.isEmpty(userId)) {
            throw new NeedAuthenticationException();
        }
        return new ResponseEntity<ResponseDto>(ResponseDto.ok(iAdminService.revert(request.getIdentity(), request.getBookItemId(),
                userId)), HttpStatus.OK);
    }

    @ApiOperation(value = "预约确认", produces = "application/json")
    @PutMapping("/confirmAppointment")
    public ResponseEntity<ResponseDto> confirmAppointment(@Valid @RequestBody OperatorBookItemDto request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        String userId = authentication.getUserId();
        if (StringUtils.isEmpty(userId)) {
            throw new NeedAuthenticationException();
        }
        return new ResponseEntity<ResponseDto>(ResponseDto.ok(iAdminService.confirmAppointment(request.getBookItemId())), HttpStatus.OK);
    }

    @ApiOperation(value = "预约待确认图书列表", produces = "application/json")
    @GetMapping("/apponitmentQuery")
    public ResponseEntity<ResponseDto> apponitmentQuery(@RequestParam(required = false) Integer area) {
        return new ResponseEntity<ResponseDto>(ResponseDto.ok(iAdminService.appointmentQuery(area)), HttpStatus.OK);
    }
}
