package com.enokb.librarian.service;

import com.enokb.librarian.dto.user.UserDto;
import com.enokb.librarian.model.UserRegisterModel;

public interface IAuthService {
    boolean register (UserRegisterModel registerModel);
    String login(String studentId, String password);
    String refresh(String oldToken);
}
