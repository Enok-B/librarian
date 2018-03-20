package com.enokb.librarian.service.impl;

import com.enokb.librarian.config.exception.UserExistException;
import com.enokb.librarian.domain.RoleUserDomain;
import com.enokb.librarian.domain.UserDomain;
import com.enokb.librarian.enums.UserRoles;
import com.enokb.librarian.mapper.RoleUserMapper;
import com.enokb.librarian.mapper.UserExtMapper;
import com.enokb.librarian.mapper.UserMapper;
import com.enokb.librarian.model.UserRegisterModel;
import com.enokb.librarian.service.IUserService;
import com.enokb.librarian.utils.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    @Transactional
    public boolean newUser(UserRegisterModel userDto, int credit, int quota, UserRoles role) {
        if (userExtMapper.selectByStudentId(userDto.getStudentId()) != null) {
            throw new UserExistException("studentid:" + userDto.getStudentId());
        }

        UserDomain userDomain = UserDomain.newBuilder()
                .id(IDUtil.newId())
                .username(userDto.getUsername())
                .password(encoder.encode(userDto.getPassword()))
                .borrowed(0)
                .credit(credit)
                .grade(userDto.getGrade())
                .quota(quota)
                .studentid(userDto.getStudentId())
                .build();
       return userMapper.insert(userDomain) ==1
               && roleUserMapper.insert(RoleUserDomain.newBuilder()
                .id(IDUtil.newId())
                .roleid(role.getId())
                .userid(userDomain.getId()).build()) == 1;
    }
}
