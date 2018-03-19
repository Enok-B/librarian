package com.enokb.librarian.service;

import com.enokb.librarian.dto.user.UserDto;
import com.enokb.librarian.model.UserModel;
import com.enokb.librarian.model.UserRegisterModel;

public interface IUserService {
    UserModel register(UserRegisterModel userDto);
}
