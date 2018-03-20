package com.enokb.librarian.dto.user;

import com.enokb.librarian.model.BaseModel;

import java.util.List;

public class UserDto extends BaseModel {

    private String studentId;

    private String username;

    private String password;

    private String grade;

    private Integer quota;

    private Integer credit;

    private List<String> roles;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
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

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "studentId=" + studentId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", grade='" + grade + '\'' +
                ", quota=" + quota +
                ", credit=" + credit +
                ", roles=" + roles +
                '}';
    }
}
