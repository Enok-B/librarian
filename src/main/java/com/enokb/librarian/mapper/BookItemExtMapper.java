package com.enokb.librarian.mapper;

import com.enokb.librarian.dto.book.BookBorrowDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookItemExtMapper {
    @Update("update bookitem set renewal=0 " +
            "where id=#{bookId}")
    int updateRenewalBybookId(@Param("bookId") String bookId);

    @Update("update bookitem set renewal=1, status=1, loanDate=null, loanUserId=null where id=#{id}")
    int revert(@Param("id") String bookItemId);

    @Update("update bookitem set status=#{status} where id=#{id}")
    int updateStatusById(@Param("status") int status, @Param("id") String bookItemId);

    @Select("<script>SELECT bi.isbn, bi.id, bi.loanDate, bi.renewal, b.price, b.name " +
            "FROM bookitem bi " +
            "LEFT JOIN book b on bi.isbn=b.isbn " +
            "where bi.status=3" +
            "<if test='area != null'>AND area=#{area}</if>" +
            "</script>")
    List<BookBorrowDto> listAppointment(@Param("area") Integer area);
}
