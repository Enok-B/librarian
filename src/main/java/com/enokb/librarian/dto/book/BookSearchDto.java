package com.enokb.librarian.dto.book;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@ApiModel
public class BookSearchDto {

    @ApiModelProperty(value = "isbn", required = false, example = "isbn")
    private String isbn;

    @ApiModelProperty(value = "书名", required = false, example = "魔兽争霸")
    private String name;

    @ApiModelProperty(value = "类型", required = false, example = "1")
    private Integer type;

    @ApiModelProperty(value = "作者", required = false, example = "孙煜冰")
    private String author;

    @ApiModelProperty(value = "出版社", required = false, example = "热干面出版社")
    private String press;

    public BookSearchDto() {
    }

    private BookSearchDto(Builder builder) {
        setIsbn(builder.isbn);
        setName(builder.name);
        setType(builder.type);
        setAuthor(builder.author);
        setPress(builder.press);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(BookSearchDto copy) {
        Builder builder = new Builder();
        builder.isbn = copy.getIsbn();
        builder.name = copy.getName();
        builder.type = copy.getType();
        builder.author = copy.getAuthor();
        builder.press = copy.getPress();
        return builder;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    @Override
    public String toString() {
        return "BookSearchDto{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                '}';
    }

    public static final class Builder {
        private String isbn;
        private String name;
        private Integer type;
        private String author;
        private String press;

        private Builder() {
        }

        public Builder isbn(String val) {
            isbn = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder type(Integer val) {
            type = val;
            return this;
        }

        public Builder author(String val) {
            author = val;
            return this;
        }

        public Builder press(String val) {
            press = val;
            return this;
        }

        public BookSearchDto build() {
            return new BookSearchDto(this);
        }
    }
}
