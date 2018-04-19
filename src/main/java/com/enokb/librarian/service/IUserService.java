package com.enokb.librarian.service;

import com.enokb.librarian.dto.book.BookBorrowDto;
import com.enokb.librarian.dto.user.UserDto;
import com.enokb.librarian.enums.UserRoles;
import com.enokb.librarian.model.UserRegisterModel;

import java.util.List;

public interface IUserService {
    boolean newUser(UserRegisterModel userDto, int credit, int quota, UserRoles role);
    UserDto userInfo(String identity);
    boolean newAdmin(UserRegisterModel userDto);
    List<BookBorrowDto> borrowing(String userId);
    boolean renewal(String userId, String bookItemId);
}
