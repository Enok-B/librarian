package com.enokb.librarian.domain;

import java.math.BigDecimal;

public class BookDomain {
    private String isbn;

    private String name;

    private BigDecimal price;

    private Integer type;

    private String author;

    private String press;

    public BookDomain() {
    }

    private BookDomain(Builder builder) {
        setIsbn(builder.isbn);
        setName(builder.name);
        setPrice(builder.price);
        setType(builder.type);
        setAuthor(builder.author);
        setPress(builder.press);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(BookDomain copy) {
        Builder builder = new Builder();
        builder.isbn = copy.getIsbn();
        builder.name = copy.getName();
        builder.price = copy.getPrice();
        builder.type = copy.getType();
        builder.author = copy.getAuthor();
        builder.press = copy.getPress();
        return builder;
    }

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


    public static final class Builder {
        private String isbn;
        private String name;
        private BigDecimal price;
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

        public Builder price(BigDecimal val) {
            price = val;
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

        public BookDomain build() {
            return new BookDomain(this);
        }
    }
}