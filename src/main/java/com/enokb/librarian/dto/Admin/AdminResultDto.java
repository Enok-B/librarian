package com.enokb.librarian.dto.Admin;

public class AdminResultDto {
    private Integer amdimId;

    private String name;

    private String password;

    private Boolean permission;

    private Integer area;

    public Integer getAmdimId() {
        return amdimId;
    }

    public void setAmdimId(Integer amdimId) {
        this.amdimId = amdimId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Boolean getPermission() {
        return permission;
    }

    public void setPermission(Boolean permission) {
        this.permission = permission;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }
}