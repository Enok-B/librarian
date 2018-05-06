package com.enokb.librarian.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentExtMapper {
    @Select("select userid from appointment " +
            "where bookId=#{bookId} " +
            "order by date desc limit 1")
    String appointmentUser(@Param("bookId") String bookId);
}
