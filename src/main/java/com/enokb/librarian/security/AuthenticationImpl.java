package com.enokb.librarian.security;

import com.enokb.librarian.model.JwtUserModel;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthenticationImpl implements Authentication {

    private JwtUserModel getUserDetails(){
        return (JwtUserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Override
    public String getUserId() {
        return getUserDetails().getId();
    }

    @Override
    public String getUsername() {
        return getUserDetails().getUsername();
    }
}
