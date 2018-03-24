package com.enokb.librarian.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

@ApiModel
public class BaseDto {

    @ApiModelProperty(value = "id", required = true, example = "enok")
    @NotBlank(message = "{base.id.null}")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseDto{" +
                "id='" + id + '\'' +
                '}';
    }
}
