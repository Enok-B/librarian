package com.enokb.librarian.service.impl;

import com.enokb.librarian.config.exception.RegisterFailedException;
import com.enokb.librarian.config.exception.UserExistException;
import com.enokb.librarian.domain.RoleUserDomain;
import com.enokb.librarian.domain.UserDomain;
import com.enokb.librarian.dto.user.UserDto;
import com.enokb.librarian.enums.UserRoles;
import com.enokb.librarian.mapper.RoleUserMapper;
import com.enokb.librarian.mapper.UserExtMapper;
import com.enokb.librarian.mapper.UserMapper;
import com.enokb.librarian.model.JwtUserModel;
import com.enokb.librarian.model.UserModel;
import com.enokb.librarian.model.UserRegisterModel;
import com.enokb.librarian.service.IUserService;
import com.enokb.librarian.utils.BeanMapperUtil;
import com.enokb.librarian.utils.IDUtil;
import com.enokb.librarian.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018-03-19 16:20
 **/

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserExtMapper userExtMapper;

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Override
    @Transactional
    public UserModel register(UserRegisterModel userDto) {
        if (userExtMapper.selectByStudentId(userDto.getStudentId()) != null) {
            throw new UserExistException("studentid:" + userDto.getStudentId());
        }

        UserDomain userDomain = UserDomain.newBuilder()
                .id(IDUtil.newId())
                .username(userDto.getName())
                .password(userDto.getPassword())
                .borrowed(0)
                .credit(100)
                .group(userDto.getGroup())
                .quota(3)
                .studentid(userDto.getStudentId())
                .build();
        boolean success =  false;

        success = userMapper.insert(userDomain) == 1;

        success = roleUserMapper.insert(RoleUserDomain.newBuilder()
                .id(IDUtil.newId())
                .roleid(10)
                .userid(userDomain.getId()).build()) == 1;

        if (!success) {
            throw new RegisterFailedException();
        }

        UserModel user = BeanMapperUtil.createAndCopyProperties(userDomain, UserModel.class);
        user.setRoles(Arrays.asList(UserRoles.fromId(10).getName()));
        return user;
    }
}
