package com.enokb.librarian.dto.admin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ApiModel
public class BookEntryDto {

    @ApiModelProperty(value = "isbn", required = true, example = "isbn")
    @NotBlank(message = "{book.isbn.null}")
    private String isbn;

    @ApiModelProperty(value = "书名", required = true, example = "魔兽争霸")
    @NotBlank(message = "{book.name.null}")
    private String name;

    @ApiModelProperty(value = "价格", required = true, example = "77.00")
    @NotNull(message = "{book.price.null}")
    @DecimalMin(value = "0", message = "{book.price.illegal}")
    private BigDecimal price;

    @ApiModelProperty(value = "类型", required = true, example = "1")
    @NotNull(message = "{book.type.null}")
    @Min(value = 0, message = "{book.type.illegal}")
    private Integer type;

    @ApiModelProperty(value = "作者", required = true, example = "孙煜冰")
    @NotBlank(message = "{book.author.null}")
    private String author;

    @ApiModelProperty(value = "出版社", required = true, example = "热干面出版社")
    @NotBlank(message = "{book.press.null}")
    private String press;

    @ApiModelProperty(value = "区域", required = true, example = "1")
    @NotNull(message = "{book.area.null}")
    @Min(value = 0, message = "{book.area.illegal}")
    private Integer area;

    @ApiModelProperty(value = "状态", required = true, example = "1")
    @NotNull(message = "{book.status.null}")
    @Min(value = 0, message = "{book.status.illegal}")
    private Integer status;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}