package com.enokb.librarian.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018-03-02 17:54
 **/

public class IdDto {

    @ApiModelProperty(value = "ID", required = true, example = "7")
    @NotNull(message = "{dto.id.null}")
    private Integer Id;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "IdDto{" +
                "Id='" + Id + '\'' +
                '}';
    }
}
