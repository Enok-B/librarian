package com.enokb.librarian.domain;

import java.util.Date;

public class BookDomain {
    private Integer bookId;

    private String name;

    private String isbn;

    private Float price;

    private String type;

    private String author;

    private String press;

    private Integer area;

    private Date arrivalTime;

    private Integer state;

    private Date lendDate;

    private Boolean renewFlag;

    private String operator;

    public BookDomain() {
    }

    private BookDomain(Builder builder) {
        setBookId(builder.bookId);
        setName(builder.name);
        setIsbn(builder.isbn);
        setPrice(builder.price);
        setType(builder.type);
        setAuthor(builder.author);
        setPress(builder.press);
        setArea(builder.area);
        setArrivalTime(builder.arrivalTime);
        setState(builder.state);
        setLendDate(builder.lendDate);
        setRenewFlag(builder.renewFlag);
        setOperator(builder.operator);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(BookDomain copy) {
        Builder builder = new Builder();
        builder.bookId = copy.getBookId();
        builder.name = copy.getName();
        builder.isbn = copy.getIsbn();
        builder.price = copy.getPrice();
        builder.type = copy.getType();
        builder.author = copy.getAuthor();
        builder.press = copy.getPress();
        builder.area = copy.getArea();
        builder.arrivalTime = copy.getArrivalTime();
        builder.state = copy.getState();
        builder.lendDate = copy.getLendDate();
        builder.renewFlag = copy.getRenewFlag();
        builder.operator = copy.getOperator();
        return builder;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Boolean getRenewFlag() {
        return renewFlag;
    }

    public void setRenewFlag(Boolean renewFlag) {
        this.renewFlag = renewFlag;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }


    public static final class Builder {
        private Integer bookId;
        private String name;
        private String isbn;
        private Float price;
        private String type;
        private String author;
        private String press;
        private Integer area;
        private Date arrivalTime;
        private Integer state;
        private Date lendDate;
        private Boolean renewFlag;
        private String operator;

        private Builder() {
        }

        public Builder bookId(Integer val) {
            bookId = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder isbn(String val) {
            isbn = val;
            return this;
        }

        public Builder price(Float val) {
            price = val;
            return this;
        }

        public Builder type(String val) {
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

        public Builder area(Integer val) {
            area = val;
            return this;
        }

        public Builder arrivalTime(Date val) {
            arrivalTime = val;
            return this;
        }

        public Builder state(Integer val) {
            state = val;
            return this;
        }

        public Builder lendDate(Date val) {
            lendDate = val;
            return this;
        }

        public Builder renewFlag(Boolean val) {
            renewFlag = val;
            return this;
        }

        public Builder operator(String val) {
            operator = val;
            return this;
        }

        public BookDomain build() {
            return new BookDomain(this);
        }
    }
}