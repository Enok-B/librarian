package com.enokb.librarian.service;

import com.enokb.librarian.dto.user.UserDto;
import com.enokb.librarian.enums.UserRoles;
import com.enokb.librarian.model.UserRegisterModel;

public interface IUserService {
    boolean newUser(UserRegisterModel userDto, int credit, int quota, UserRoles role);
    UserDto userInfo(String identity);
    boolean newAdmin(UserRegisterModel userDto);
}
