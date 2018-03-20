package com.enokb.librarian.service;

import com.enokb.librarian.dto.user.UserDto;
import com.enokb.librarian.model.UserRegisterModel;

public interface IAuthService {
    UserDto register (UserRegisterModel registerModel);
}
