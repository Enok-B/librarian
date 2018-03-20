package com.enokb.librarian.model;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018-03-19 16:34
 **/

public class UserRegisterModel {

    private String studentId;

    private String username;

    private String password;

    private String grade;

    public UserRegisterModel() {
    }

    private UserRegisterModel(Builder builder) {
        setStudentId(builder.studentId);
        setUsername(builder.username);
        setPassword(builder.password);
        setGrade(builder.grade);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(UserRegisterModel copy) {
        Builder builder = new Builder();
        builder.studentId = copy.getStudentId();
        builder.username = copy.getUsername();
        builder.password = copy.getPassword();
        builder.grade = copy.getGrade();
        return builder;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


    public static final class Builder {
        private String studentId;
        private String username;
        private String password;
        private String grade;

        private Builder() {
        }

        public Builder studentId(String val) {
            studentId = val;
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

        public UserRegisterModel build() {
            return new UserRegisterModel(this);
        }
    }
}
