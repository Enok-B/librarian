package com.enokb.librarian.mapper;

import com.enokb.librarian.domain.CheckoutlogDomain;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CheckoutlogMapper {
    @Delete({
        "delete from checkoutlog",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into checkoutlog (id, userId, ",
        "bookId, operator, ",
        "date, status)",
        "values (#{id,jdbcType=VARCHAR}, #{userid,jdbcType=VARCHAR}, ",
        "#{bookid,jdbcType=VARCHAR}, #{operator,jdbcType=VARCHAR}, ",
        "#{date,jdbcType=TIMESTAMP}, #{status,jdbcType=BIT})"
    })
    int insert(CheckoutlogDomain record);

    @Select({
        "select",
        "id, userId, bookId, operator, date, status",
        "from checkoutlog",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="userId", property="userid", jdbcType=JdbcType.VARCHAR),
        @Result(column="bookId", property="bookid", jdbcType=JdbcType.VARCHAR),
        @Result(column="operator", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="date", property="date", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    CheckoutlogDomain selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, userId, bookId, operator, date, status",
        "from checkoutlog"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="userId", property="userid", jdbcType=JdbcType.VARCHAR),
        @Result(column="bookId", property="bookid", jdbcType=JdbcType.VARCHAR),
        @Result(column="operator", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="date", property="date", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    List<CheckoutlogDomain> selectAll();

    @Update({
        "update checkoutlog",
        "set userId = #{userid,jdbcType=VARCHAR},",
          "bookId = #{bookid,jdbcType=VARCHAR},",
          "operator = #{operator,jdbcType=VARCHAR},",
          "date = #{date,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=BIT}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(CheckoutlogDomain record);
}