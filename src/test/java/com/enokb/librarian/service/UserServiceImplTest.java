package com.enokb.librarian.service;

import com.enokb.librarian.mapper.RoleUserMapper;
import com.enokb.librarian.mapper.UserExtMapper;
import com.enokb.librarian.mapper.UserMapper;
import com.enokb.librarian.model.UserRegisterModel;
import com.enokb.librarian.service.impl.UserServiceImpl;
import com.enokb.librarian.utils.JwtTokenUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {UserServiceImpl.class})
public class UserServiceImplTest {

    @MockBean
    private UserMapper userMapper;

    @MockBean
    private UserExtMapper userExtMapper;

    @MockBean
    private RoleUserMapper roleUserMapper;

    @MockBean
    private UserDetailsService userDetailsService;

    @MockBean
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserServiceImpl userService;

    public void setUp() {
        given(userExtMapper.selectByName("enok")).willReturn(null);
        given(jwtTokenUtil.generateToken(ArgumentMatchers.any())).willReturn("token");
        given(userMapper.insert(ArgumentMatchers.any())).willReturn(1);
        given(roleUserMapper.insert(ArgumentMatchers.any())).willReturn(1);
    }

    @Test
    public void register() {
//        userService.register(UserRegisterModel.newBuilder()
//                .username("enok")
//                .password("123456")
//                .grade("大四")
//                .studentId("01558895554").build());
    }
}