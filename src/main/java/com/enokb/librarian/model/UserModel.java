package com.enokb.librarian.model;

import java.util.List;

public class UserModel extends BaseModel {

    private Integer studentId;

    private String name;

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

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", grade='" + grade + '\'' +
                ", quota=" + quota +
                ", credit=" + credit +
                ", roles=" + roles +
                '}';
    }
}
