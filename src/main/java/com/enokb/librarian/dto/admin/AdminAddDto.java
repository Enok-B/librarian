package com.enokb.librarian.dto.admin;

import com.enokb.librarian.dto.auth.LoginDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018-03-21 10:04
 **/
@ApiModel
public class AdminAddDto extends LoginDto{

    @ApiModelProperty(value = "管理员昵称", required = true, example = "enok")
    @NotBlank(message = "{auth.username.null}")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
