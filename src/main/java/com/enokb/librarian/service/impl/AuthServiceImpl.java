package com.enokb.librarian.service.impl;

import com.enokb.librarian.dto.user.UserDto;
import com.enokb.librarian.enums.UserRoles;
import com.enokb.librarian.model.JwtUserModel;
import com.enokb.librarian.model.UserRegisterModel;
import com.enokb.librarian.service.IAuthService;
import com.enokb.librarian.service.IUserService;
import com.enokb.librarian.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    private static final int CREDIT = 100;
    private static final int QUOTA = 3;

    @Override
    public boolean register(UserRegisterModel registerModel) {
        return iUserService.newUser(registerModel, CREDIT, QUOTA, UserRoles.USER);
    }

    @Override
    public String login(String identity, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(identity, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(identity);
        final String token = jwtTokenUtil.generateToken(userDetails);
        return token;
    }

    @Override
    public String refresh(String oldToken) {
        final String token = oldToken.substring(tokenHead.length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUserModel user = (JwtUserModel) userDetailsService.loadUserByUsername(username);
        return jwtTokenUtil.refreshToken(token);
    }
}
