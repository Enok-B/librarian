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
public class RegisterDto extends LoginDto{

    @ApiModelProperty(value = "用户昵称", required = true, example = "enok")
    @NotBlank(message = "{auth.username.null}")
    private String username;

    @ApiModelProperty(value = "班级", required = true, example = "三年二班")
    @NotBlank(message = "{auth.grade.null}")
    private String grade;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
