package com.enokb.librarian.dto.admin;

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
public class OperatorBorrowDto {

    @ApiModelProperty(value = "用户identity", required = true, example = "syb")
    @NotBlank(message = "{auth.id.null}")
    private String identity;

    @ApiModelProperty(value = "图书子项ID", required = true, example = "item")
    @NotBlank(message = "{book.itemid.null}")
    private String bookItemId;

    public String getIdentity() {
        return this.identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getBookItemId() {
        return this.bookItemId;
    }

    public void setBookItemId(String bookItemId) {
        this.bookItemId = bookItemId;
    }
}
