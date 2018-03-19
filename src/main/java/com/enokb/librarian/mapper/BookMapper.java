package com.enokb.librarian.mapper;

import com.enokb.librarian.domain.BookDomain;
import com.enokb.librarian.model.BookSearchModel;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookMapper {
    @Delete({
        "delete from book",
        "where isbn = #{isbn,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String isbn);

    @Insert({
        "insert into book (isbn, name, ",
        "price, type, author, ",
        "press)",
        "values (#{isbn,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{price,jdbcType=DECIMAL}, #{type,jdbcType=INTEGER}, #{author,jdbcType=VARCHAR}, ",
        "#{press,jdbcType=VARCHAR})"
    })
    int insert(BookDomain record);

    @Select({
        "select",
        "isbn, name, price, type, author, press",
        "from book",
        "where isbn = #{isbn,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="isbn", property="isbn", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="author", property="author", jdbcType=JdbcType.VARCHAR),
        @Result(column="press", property="press", jdbcType=JdbcType.VARCHAR)
    })
    BookDomain selectByPrimaryKey(String isbn);

    @Select({
        "select",
        "isbn, name, price, type, author, press",
        "from book"
    })
    @Results({
        @Result(column="isbn", property="isbn", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="author", property="author", jdbcType=JdbcType.VARCHAR),
        @Result(column="press", property="press", jdbcType=JdbcType.VARCHAR)
    })
    List<BookDomain> selectAll();

    @Update({
        "update book",
        "set name = #{name,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=DECIMAL},",
          "type = #{type,jdbcType=INTEGER},",
          "author = #{author,jdbcType=VARCHAR},",
          "press = #{press,jdbcType=VARCHAR}",
        "where isbn = #{isbn,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(BookDomain record);
}