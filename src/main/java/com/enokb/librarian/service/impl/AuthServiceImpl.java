package com.enokb.librarian.service.impl;

import com.enokb.librarian.dto.user.UserDto;
import com.enokb.librarian.enums.UserRoles;
import com.enokb.librarian.model.UserRegisterModel;
import com.enokb.librarian.service.IAuthService;
import com.enokb.librarian.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018-03-20 09:31
 **/

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private IUserService iUserService;

    @Override
    public UserDto register(UserRegisterModel registerModel) {
        if (iUserService.newUser(registerModel, 100, 3, UserRoles.USER)) {
            return null;
        }
        return null;
    }
}
