package com.enokb.librarian.model;

public class BookSearchModel {
    private String isbn;
    private String name;
    private Integer type;
    private String author;
    private String press;

    public BookSearchModel() {
    }

    private BookSearchModel(Builder builder) {
        setIsbn(builder.isbn);
        setName(builder.name);
        setType(builder.type);
        setAuthor(builder.author);
        setPress(builder.press);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(BookSearchModel copy) {
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
        return "BookSearchModel{" +
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

        public BookSearchModel build() {
            return new BookSearchModel(this);
        }
    }
}
