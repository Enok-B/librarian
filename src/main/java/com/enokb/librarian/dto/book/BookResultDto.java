package com.enokb.librarian.dto.book;

import com.enokb.librarian.enums.BookType;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookResultDto {

    private String isbn;
    private String name;
    private BigDecimal price;
    private BookType type;
    private String author;
    private String press;
    private List<BookItemResultDto> items;

    public BookResultDto() {
    }

    private BookResultDto(Builder builder) {
        setIsbn(builder.isbn);
        setName(builder.name);
        setPrice(builder.price);
        setType(builder.type.getType());
        setAuthor(builder.author);
        setPress(builder.press);
        setItems(builder.items);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(BookResultDto copy) {
        Builder builder = new Builder();
        builder.isbn = copy.getIsbn();
        builder.name = copy.getName();
        builder.price = copy.getPrice();
        builder.type = copy.getType();
        builder.author = copy.getAuthor();
        builder.press = copy.getPress();
        builder.items = copy.getItems();
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BookType getType() {
        return type;
    }

    public void setType(int type) {
        this.type = BookType.forType(type);
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

    public List<BookItemResultDto> getItems() {
        return items;
    }

    public void setItems(List<BookItemResultDto> items) {
        this.items = items;
    }


    public static final class Builder {
        private String isbn;
        private String name;
        private BigDecimal price;
        private BookType type;
        private String author;
        private String press;
        private List<BookItemResultDto> items;

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

        public Builder price(BigDecimal val) {
            price = val;
            return this;
        }

        public Builder type(BookType val) {
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

        public Builder items(List<BookItemResultDto> val) {
            items = val;
            return this;
        }

        public BookResultDto build() {
            return new BookResultDto(this);
        }
    }
}
