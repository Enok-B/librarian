package com.enokb.librarian.dto.Admin;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AdminDto {

    @ApiModelProperty(value = "AdminId", required = true, example = "7")
    @NotNull(message = "{dto.id.null}")
    private Integer amdimId;

    @ApiModelProperty(value = "Admin用户名", required = true, example = "Enok")
    @NotBlank(message = "{admin.name.null}")
    private String name;

    @ApiModelProperty(value = "密码", required = true, example = "password")
    @NotBlank(message = "{admin.pass.null}")
    private String password;

    @ApiModelProperty(value = "权限", required = true, example = "true")
    private Boolean permission = false;

    @ApiModelProperty(value = "管理区域", required = true, example = "1")
    @NotNull(message = "{admin.permission.null}")
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