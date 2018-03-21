package com.enokb.librarian.security;

import com.enokb.librarian.domain.UserDomain;
import com.enokb.librarian.model.JwtUserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUserModel create(UserDomain user) {
        return JwtUserModel.newBuilder()
                .id(user.getId())
                .studentId(user.getIdentity())
                .password(user.getPassword())
                .authorities(mapToGrantedAuthorities(user.getRoles()
                        .stream().map(r -> r.getName()).collect(Collectors.toList())))
                .build();
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
