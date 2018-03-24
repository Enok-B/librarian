package com.enokb.librarian.domain;

import com.enokb.librarian.generate.model.Role;

import java.util.List;

public class UserDomain {
    private String id;

    private String identity;

    private String username;

    private String password;

    private String grade;

    private Integer quota;

    private Integer borrowed;

    private Integer credit;

    private List<Role> roles;

    public UserDomain() {
    }

    private UserDomain(Builder builder) {
        setId(builder.id);
        setIdentity(builder.identity);
        setUsername(builder.username);
        setPassword(builder.password);
        setGrade(builder.grade);
        setQuota(builder.quota);
        setBorrowed(builder.borrowed);
        setCredit(builder.credit);
        setRoles(builder.roles);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(UserDomain copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.identity = copy.getIdentity();
        builder.username = copy.getUsername();
        builder.password = copy.getPassword();
        builder.grade = copy.getGrade();
        builder.quota = copy.getQuota();
        builder.borrowed = copy.getBorrowed();
        builder.credit = copy.getCredit();
        builder.roles = copy.getRoles();
        return builder;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    public Integer getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Integer borrowed) {
        this.borrowed = borrowed;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    public static final class Builder {
        private String id;
        private String identity;
        private String username;
        private String password;
        private String grade;
        private Integer quota;
        private Integer borrowed;
        private Integer credit;
        private Boolean role;
        private String token;
        private List<Role> roles;

        private Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder identity(String val) {
            identity = val;
            return this;
        }

        public Builder username(String val) {
            username = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder grade(String val) {
            grade = val;
            return this;
        }

        public Builder quota(Integer val) {
            quota = val;
            return this;
        }

        public Builder borrowed(Integer val) {
            borrowed = val;
            return this;
        }

        public Builder credit(Integer val) {
            credit = val;
            return this;
        }

        public Builder role(Boolean val) {
            role = val;
            return this;
        }

        public Builder token(String val) {
            token = val;
            return this;
        }

        public Builder roles(List<Role> val) {
            roles = val;
            return this;
        }

        public UserDomain build() {
            return new UserDomain(this);
        }
    }
}