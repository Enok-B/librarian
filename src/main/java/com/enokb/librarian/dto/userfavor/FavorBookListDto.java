package com.enokb.librarian.dto.userfavor;

import com.enokb.librarian.enums.BookStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

/**
 * @program: librarian
 * @description: favor books
 * @author: ksewen
 * @create: 2018/4/2 下午8:37
 **/

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FavorBookListDto {
    private String id;

    private String isbn;

    private String name;

    private String author;

    private String press;

    private Integer area;

    private BookStatus status;

    private Date loandate;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Date getLoandate() {
        return loandate;
    }

    public void setLoandate(Date loandate) {
        this.loandate = loandate;
    }
}
