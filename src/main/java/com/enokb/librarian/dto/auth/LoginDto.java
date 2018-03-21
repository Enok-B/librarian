package com.enokb.librarian.dto.auth;

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
public class LoginDto {

    @ApiModelProperty(value = "身份标识", required = true, example = "10086")
    @NotBlank(message = "{auth.id.null}")
    private String identity;

    @ApiModelProperty(value = "密码", required = true, example = "password")
    @NotBlank(message = "{auth.pass.null}")
    private String password;

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
