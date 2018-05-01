package com.enokb.librarian.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018/4/19 下午12:01
 **/

@ApiModel
public class OperatorBookItemDto {

    @ApiModelProperty(value = "图书子项ID", required = true, example = "item")
    @NotBlank(message = "{book.itemid.null}")
    private String bookItemId;

    public String getBookItemId() {
        return this.bookItemId;
    }

    public void setBookItemId(String bookItemId) {
        this.bookItemId = bookItemId;
    }
}
