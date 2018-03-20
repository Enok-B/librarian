package com.enokb.librarian.domain;

import java.util.List;

public class UserDomain {
    private String id;

    private String studentid;

    private String username;

    private String password;

    private String grade;

    private Integer quota;

    private Integer borrowed;

    private Integer credit;

    private String token;

    private List<RoleDomain> roles;

    public UserDomain() {
    }

    private UserDomain(Builder builder) {
        setId(builder.id);
        setStudentid(builder.studentid);
        setUsername(builder.username);
        setPassword(builder.password);
        setGrade(builder.grade);
        setQuota(builder.quota);
        setBorrowed(builder.borrowed);
        setCredit(builder.credit);
        setToken(builder.token);
        setRoles(builder.roles);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(UserDomain copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.studentid = copy.getStudentid();
        builder.username = copy.getUsername();
        builder.password = copy.getPassword();
        builder.grade = copy.getGrade();
        builder.quota = copy.getQuota();
        builder.borrowed = copy.getBorrowed();
        builder.credit = copy.getCredit();
        builder.token = copy.getToken();
        builder.roles = copy.getRoles();
        return builder;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid == null ? null : studentid.trim();
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public List<RoleDomain> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDomain> roles) {
        this.roles = roles;
    }


    public static final class Builder {
        private String id;
        private String studentid;
        private String username;
        private String password;
        private String grade;
        private Integer quota;
        private Integer borrowed;
        private Integer credit;
        private Boolean role;
        private String token;
        private List<RoleDomain> roles;

        private Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder studentid(String val) {
            studentid = val;
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

        public Builder roles(List<RoleDomain> val) {
            roles = val;
            return this;
        }

        public UserDomain build() {
            return new UserDomain(this);
        }
    }
}