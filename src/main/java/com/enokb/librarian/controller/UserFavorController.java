package com.enokb.librarian.controller;

import com.enokb.librarian.config.exception.InvalidParamException;
import com.enokb.librarian.config.exception.NeedAuthenticationException;
import com.enokb.librarian.dto.ResponseDto;
import com.enokb.librarian.dto.userfavor.FavorBookDto;
import com.enokb.librarian.model.JwtUserModel;
import com.enokb.librarian.security.Authentication;
import com.enokb.librarian.service.IUserFavorService;
import io.jsonwebtoken.Jwt;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/favor")
public class UserFavorController {

    @Autowired
    private Authentication authentication;

    @Autowired
    private IUserFavorService iUserFavorService;

    @ApiOperation(value = "收藏/取消收藏", produces = "application/json")
    @PutMapping("/book")
    public ResponseEntity<ResponseDto> userInfo(@Valid @RequestBody FavorBookDto request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        String userId = authentication.getUserId();
        if (StringUtils.isEmpty(userId)) {
            throw new NeedAuthenticationException();
        }
        return new ResponseEntity<ResponseDto>(ResponseDto.ok(iUserFavorService
                .favorBook(userId, request.getId(),request.isFavor())), HttpStatus.OK);
    }

}
