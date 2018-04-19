package com.enokb.librarian.dto.admin;

import com.enokb.librarian.dto.user.RenewalDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018/4/12 下午9:48
 **/

@ApiModel
public class OperatorBorrowDto extends RenewalDto {

    @ApiModelProperty(value = "用户identity", required = true, example = "syb")
    @NotBlank(message = "{auth.id.null}")
    private String identity;

    public String getIdentity() {
        return this.identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }


}
