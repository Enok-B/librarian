package com.enokb.librarian.dto.userfavor;

import com.enokb.librarian.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class FavorBookDto extends BaseDto {

    @ApiModelProperty(value = "是否收藏", required = false, example = "false")
    private boolean favor = false;

    public boolean isFavor() {
        return favor;
    }

    public void setFavor(boolean favor) {
        this.favor = favor;
    }

    @Override
    public String toString() {
        return "FavorBookDto{" +
                "favor=" + favor +
                '}';
    }
}
