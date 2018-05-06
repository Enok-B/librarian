package com.enokb.librarian.mapper;

import com.enokb.librarian.dto.book.BookBorrowDto;
import com.enokb.librarian.generate.model.Checkoutlog;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckOutLogExtMapper {
    @Select("SELECT bi.isbn, bi.id, bi.loanDate, bi.renewal, b.price, b.name " +
            "FROM checkoutlog as cl " +
            "LEFT JOIN bookitem bi on cl.bookId=bi.id " +
            "LEFT JOIN book b on bi.isbn=b.isbn " +
            "where cl.userId=#{userId} and cl.status=1")
    List<BookBorrowDto> borrowing(@Param("userId") String userId);

    @Select("SELECT id,status FROM checkoutlog " +
            "where userId=#{userId} and bookId=#{bookId}")
    Checkoutlog logSelectByUserAndBook(@Param("userId") String userId, @Param("bookId") String bookItemId);

    @Update("update checkoutlog set status=0, operator=#{operatorId} where bookId=#{bookId}")
    int revert(@Param("bookId") String bookId, @Param("operatorId") String operatorId);
}
