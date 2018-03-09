package com.enokb.librarian.controller;

import com.enokb.librarian.config.exception.InvalidParamException;
import com.enokb.librarian.domain.AdminDomain;
import com.enokb.librarian.dto.Admin.AdminDto;
import com.enokb.librarian.dto.Admin.AdminResultDto;
import com.enokb.librarian.dto.ResponseDto;
import com.enokb.librarian.dto.book.BookResultDto;
import com.enokb.librarian.dto.book.BookSearchDto;
import com.enokb.librarian.dto.book.BookSearchResultDto;
import com.enokb.librarian.model.BookSearchModel;
import com.enokb.librarian.service.IBookService;
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

@RestController
@RequestMapping("/book")
@Validated
public class BookController {

    @Autowired
    private IBookService iBookService;

    @ApiOperation(value = "搜索书籍", produces = "application/json")
    @PostMapping("/search")
    public ResponseEntity<ResponseDto> searchBook(@Valid @RequestBody BookSearchDto request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        BookSearchModel bookSearchModel = new BookSearchModel();
        BeanUtils.copyProperties(request, bookSearchModel);
        return new ResponseEntity<ResponseDto>(ResponseDto.ok(iBookService.searchBook(bookSearchModel)), HttpStatus.OK);
    }
}
