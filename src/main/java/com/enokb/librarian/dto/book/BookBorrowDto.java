package com.enokb.librarian.dto.book;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018/4/12 下午9:16
 **/

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookBorrowDto {
    private String isbn;
    private String id;
    private String name;
    private BigDecimal price;
    private Date loanDate;
    private Boolean renewal;

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getLoanDate() {
        return this.loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Boolean getRenewal() {
        return this.renewal;
    }

    public void setRenewal(Boolean renewal) {
        this.renewal = renewal;
    }
}
