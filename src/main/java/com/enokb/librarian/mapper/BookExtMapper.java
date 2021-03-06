package com.enokb.librarian.mapper;

import com.enokb.librarian.generate.model.Book;
import com.enokb.librarian.generate.model.Bookitem;
import com.enokb.librarian.model.BookSearchModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018-03-17 18:07
 **/
@Repository
public interface BookExtMapper {
    @Select("<script>SELECT isbn, name, price, type, author, press " +
            "FROM book " +
            "WHERE 1=1 " +
            "<if test='condition.isbn != null and condition.isbn != \"\"'>AND isbn=#{condition.isbn}</if> " +
            "<if test='condition.name != null and condition.name != \"\"'>AND LOCATE(#{condition.name}, `name`)>0</if> " +
            "<if test='condition.type != null and condition.type != \"\"'>AND type=#{condition.type}</if> " +
            "<if test='condition.author != null and condition.author != \"\"'>AND LOCATE(#{condition.author}, `author`)>0</if> " +
            "<if test='condition.press != null and condition.press != \"\"'>AND LOCATE(#{condition.press}, `press`)>0</if> </script>")
    List<Book> searchBook(@Param("condition") BookSearchModel bookSearchModel);

    @Select("SELECT id, isbn, area, status, loanDate, renewal " +
            "FROM librarian.bookitem where isbn=#{isbn}")
    List<Bookitem> bookDetail(@Param("isbn") String isbn);

    @Insert("INSERT INTO book (isbn,name,price,type,author,press) " +
            "SELECT #{book.isbn},#{book.name},#{book.price},#{book.type},#{book.author},#{book.press} " +
            " FROM dual " +
            " where not exists (SELECT " +
            "isbn " +
            "FROM " +
            "book " +
            "where " +
            "isbn=#{book.isbn})")
    int insertIfNotExistBook(@Param("book") Book record);
}
