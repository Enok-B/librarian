package com.enokb.librarian.mapper;

import com.enokb.librarian.domain.BookitemDomain;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookitemMapper {
    @Delete({
        "delete from bookitem",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into bookitem (id, isbn, ",
        "area, status, storeTime, ",
        "loanDate, loanUserId, ",
        "renewal, operator)",
        "values (#{id,jdbcType=VARCHAR}, #{isbn,jdbcType=VARCHAR}, ",
        "#{area,jdbcType=INTEGER}, #{status,jdbcType=BIT}, #{storetime,jdbcType=TIMESTAMP}, ",
        "#{loandate,jdbcType=TIMESTAMP}, #{loanuserid,jdbcType=VARCHAR}, ",
        "#{renewal,jdbcType=BIT}, #{operator,jdbcType=VARCHAR})"
    })
    int insert(BookitemDomain record);

    @Select({
        "select",
        "id, isbn, area, status, storeTime, loanDate, loanUserId, renewal, operator",
        "from bookitem",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="isbn", property="isbn", jdbcType=JdbcType.VARCHAR),
        @Result(column="area", property="area", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT),
        @Result(column="storeTime", property="storetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="loanDate", property="loandate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="loanUserId", property="loanuserid", jdbcType=JdbcType.VARCHAR),
        @Result(column="renewal", property="renewal", jdbcType=JdbcType.BIT),
        @Result(column="operator", property="operator", jdbcType=JdbcType.VARCHAR)
    })
    BookitemDomain selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, isbn, area, status, storeTime, loanDate, loanUserId, renewal, operator",
        "from bookitem"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="isbn", property="isbn", jdbcType=JdbcType.VARCHAR),
        @Result(column="area", property="area", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT),
        @Result(column="storeTime", property="storetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="loanDate", property="loandate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="loanUserId", property="loanuserid", jdbcType=JdbcType.VARCHAR),
        @Result(column="renewal", property="renewal", jdbcType=JdbcType.BIT),
        @Result(column="operator", property="operator", jdbcType=JdbcType.VARCHAR)
    })
    List<BookitemDomain> selectAll();

    @Update({
        "update bookitem",
        "set isbn = #{isbn,jdbcType=VARCHAR},",
          "area = #{area,jdbcType=INTEGER},",
          "status = #{status,jdbcType=BIT},",
          "storeTime = #{storetime,jdbcType=TIMESTAMP},",
          "loanDate = #{loandate,jdbcType=TIMESTAMP},",
          "loanUserId = #{loanuserid,jdbcType=VARCHAR},",
          "renewal = #{renewal,jdbcType=BIT},",
          "operator = #{operator,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(BookitemDomain record);
}