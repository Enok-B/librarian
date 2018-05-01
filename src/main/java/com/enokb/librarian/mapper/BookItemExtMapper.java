package com.enokb.librarian.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface BookItemExtMapper {
    @Update("update bookitem set renewal=0 " +
            "where id=#{bookId}")
    int updateRenewalBybookId(@Param("bookId") String bookId);

    @Update("update bookitem set renewal=1, status=1, loanDate=null, loanUserId=null where id=#{id}")
    int revert(@Param("id") String bookItemId);

    @Update("update bookitem set status=3 where id=#{}")
    int appointment(@Param("id") String bookItemId);
}
