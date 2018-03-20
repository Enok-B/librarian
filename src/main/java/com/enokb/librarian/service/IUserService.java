package com.enokb.librarian.service;

import com.enokb.librarian.enums.UserRoles;
import com.enokb.librarian.model.UserModel;
import com.enokb.librarian.model.UserRegisterModel;

public interface IUserService {
    boolean newUser(UserRegisterModel userDto, int credit, int quota, UserRoles role);
}
