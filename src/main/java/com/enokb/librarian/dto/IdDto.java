package com.enokb.librarian.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018-03-02 17:54
 **/

public class IdDto {

    @ApiModelProperty(value = "ID", required = true, example = "7")
    @NotBlank(message = "{dto.id.null}")
    private String Id;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "IdDto{" +
                "Id='" + Id + '\'' +
                '}';
    }
}
