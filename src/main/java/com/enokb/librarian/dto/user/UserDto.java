package com.enokb.librarian.dto.user;

import com.enokb.librarian.model.BaseModel;

import java.util.List;

public class UserDto extends BaseModel {

    private Integer studentId;

    private String name;

    private String password;

    private String group;

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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
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
                ", group='" + group + '\'' +
                ", quota=" + quota +
                ", credit=" + credit +
                ", roles=" + roles +
                '}';
    }
}
