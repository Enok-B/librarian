package com.enokb.librarian.mapper;

import com.enokb.librarian.dto.book.BookBorrowDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckOutLogExtMapper {
    @Select("SELECT bi.isbn, bi.id, bi.loanDate, bi.renewal, b.price, b.name " +
            "FROM checkoutlog as cl " +
            "LEFT JOIN bookitem bi on cl.bookId=bi.id " +
            "LEFT JOIN book b on bi.isbn=b.isbn " +
            "where userId=#{userId}")
    List<BookBorrowDto> borrowing(@Param("userId") String userId);
}
