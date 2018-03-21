package com.enokb.librarian.model;

import com.enokb.librarian.dto.user.UserDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class JwtUserModel implements UserDetails {
    private String id;
    private String studentId;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUserModel() {
    }

    private JwtUserModel(Builder builder) {
        setId(builder.id);
        setStudentId(builder.studentId);
        setPassword(builder.password);
        setAuthorities(builder.authorities);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(JwtUserModel copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.studentId = copy.getStudentId();
        builder.password = copy.getPassword();
        builder.authorities = copy.getAuthorities();
        return builder;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return studentId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }


    public static final class Builder {
        private String id;
        private String studentId;
        private String password;
        private Collection<? extends GrantedAuthority> authorities;

        private Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder studentId(String val) {
            studentId = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder authorities(Collection<? extends GrantedAuthority> val) {
            authorities = val;
            return this;
        }

        public JwtUserModel build() {
            return new JwtUserModel(this);
        }
    }
}
