package com.enokb.librarian.mapper;

import com.enokb.librarian.domain.BookDomain;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface BookMapper {

    @Delete({
            "delete from book",
            "where book_Id = #{bookId,jdbcType=INTEGER}"
    })
    int deleteById(Integer bookId);

    @Insert({
            "insert into book (book_Id, name, ",
            "isbn, price, type, ",
            "writer, press, area, ",
            "arrival_time, state, ",
            "Lend_date, renew_flag, operator)",
            "values (#{bookId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
            "#{isbn,jdbcType=VARCHAR}, #{price,jdbcType=REAL}, #{type,jdbcType=VARCHAR}, ",
            "#{writer,jdbcType=VARCHAR}, #{press,jdbcType=VARCHAR}, #{area,jdbcType=INTEGER}, ",
            "#{arrivalTime,jdbcType=TIMESTAMP}, #{state,jdbcType=INTEGER}, ",
            "#{lendDate,jdbcType=DATE}, #{renewFlag,jdbcType=BIT}, #{operator,jdbcType=VARCHAR})"
    })
    int insert(BookDomain record);

    @Select({
            "select",
            "book_Id, name, isbn, price, type, writer, press, area, arrival_time, state, ",
            "Lend_date, renew_flag, operator",
            "from book",
            "where book_Id = #{bookId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "book_Id", property = "bookId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "isbn", property = "isbn", jdbcType = JdbcType.VARCHAR),
            @Result(column = "price", property = "price", jdbcType = JdbcType.REAL),
            @Result(column = "type", property = "type", jdbcType = JdbcType.VARCHAR),
            @Result(column = "writer", property = "writer", jdbcType = JdbcType.VARCHAR),
            @Result(column = "press", property = "press", jdbcType = JdbcType.VARCHAR),
            @Result(column = "area", property = "area", jdbcType = JdbcType.INTEGER),
            @Result(column = "arrival_time", property = "arrivalTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "state", property = "state", jdbcType = JdbcType.INTEGER),
            @Result(column = "Lend_date", property = "lendDate", jdbcType = JdbcType.DATE),
            @Result(column = "renew_flag", property = "renewFlag", jdbcType = JdbcType.BIT),
            @Result(column = "operator", property = "operator", jdbcType = JdbcType.VARCHAR)
    })
    BookDomain selectById(Integer bookId);

    @Update({
            "update book",
            "set name = #{name,jdbcType=VARCHAR},",
            "isbn = #{isbn,jdbcType=VARCHAR},",
            "price = #{price,jdbcType=REAL},",
            "type = #{type,jdbcType=VARCHAR},",
            "writer = #{writer,jdbcType=VARCHAR},",
            "press = #{press,jdbcType=VARCHAR},",
            "area = #{area,jdbcType=INTEGER},",
            "arrival_time = #{arrivalTime,jdbcType=TIMESTAMP},",
            "state = #{state,jdbcType=INTEGER},",
            "Lend_date = #{lendDate,jdbcType=DATE},",
            "renew_flag = #{renewFlag,jdbcType=BIT},",
            "operator = #{operator,jdbcType=VARCHAR}",
            "where book_Id = #{bookId,jdbcType=INTEGER}"
    })
    int updateById(BookDomain record);
}