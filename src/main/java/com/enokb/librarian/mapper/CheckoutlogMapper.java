package com.enokb.librarian.mapper;

import com.enokb.librarian.domain.CheckoutlogDomain;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface CheckoutlogMapper {

    @Delete({
        "delete from checkoutlog",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteById(Integer id);

    @Insert({
        "insert into checkoutlog (Id, userId, ",
        "bookId, adminId, ",
        "date, state_flag)",
        "values (#{id,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
        "#{bookid,jdbcType=INTEGER}, #{adminid,jdbcType=INTEGER}, ",
        "#{date,jdbcType=DATE}, #{stateFlag,jdbcType=INTEGER})"
    })
    int insert(CheckoutlogDomain record);

    @Select({
        "select",
        "Id, userId, bookId, adminId, date, state_flag",
        "from checkoutlog",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="bookId", property="bookid", jdbcType=JdbcType.INTEGER),
        @Result(column="adminId", property="adminid", jdbcType=JdbcType.INTEGER),
        @Result(column="date", property="date", jdbcType=JdbcType.DATE),
        @Result(column="state_flag", property="stateFlag", jdbcType=JdbcType.INTEGER)
    })
    CheckoutlogDomain selectById(Integer id);

    @Update({
        "update checkoutlog",
        "set userId = #{userid,jdbcType=INTEGER},",
          "bookId = #{bookid,jdbcType=INTEGER},",
          "adminId = #{adminid,jdbcType=INTEGER},",
          "date = #{date,jdbcType=DATE},",
          "state_flag = #{stateFlag,jdbcType=INTEGER}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateById(CheckoutlogDomain record);
}