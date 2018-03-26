package com.enokb.librarian.dto.book;

import com.enokb.librarian.enums.BookStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookItemResultDto {
    private String id;

    private String isbn;

    private Integer area;

    private BookStatus status;

    private Date loandate;

    private Boolean renewal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = BookStatus.forStatus(status);
    }

    public Date getLoandate() {
        return loandate;
    }

    public void setLoandate(Date loandate) {
        this.loandate = loandate;
    }

    public Boolean getRenewal() {
        return renewal;
    }

    public void setRenewal(Boolean renewal) {
        this.renewal = renewal;
    }
}
