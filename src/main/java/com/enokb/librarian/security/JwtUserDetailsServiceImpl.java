package com.enokb.librarian.security;

import com.enokb.librarian.domain.UserDomain;
import com.enokb.librarian.mapper.UserExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserExtMapper userExtMapper;

    @Override
    public UserDetails loadUserByUsername(String studentId) throws UsernameNotFoundException {
        UserDomain user = userExtMapper.loginByStudentId(studentId);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", studentId));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
