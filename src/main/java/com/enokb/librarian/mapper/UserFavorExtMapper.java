package com.enokb.librarian.mapper;

import com.enokb.librarian.dto.userfavor.FavorBookListDto;
import com.enokb.librarian.generate.model.Bookitem;
import com.enokb.librarian.generate.model.UserFavor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFavorExtMapper {

    @Insert("INSERT INTO user_favor (id,userId,bookId,isDel) SELECT #{info.id},#{info.userid},#{info.bookid},#{info.isdel} " +
            " FROM dual " +
            " where not exists (SELECT " +
            "id " +
            "FROM " +
            "user_favor " +
            "where " +
            "userId=#{info.userid} and bookId=#{info.bookid})")
    int insertIfNotExistRecord(@Param("info") UserFavor userFavor);

    @Update("UPDATE user_favor SET isDel=1 WHERE " +
            "userId=#{userId} AND bookId=#{bookId}")
    int deleteRecord(@Param("userId") String userId, @Param("bookId") String bookId);

    @Update("UPDATE user_favor SET isDel=0 WHERE " +
            "userId=#{userId} AND bookId=#{bookId}")
    int updateRecord(@Param("userId") String userId, @Param("bookId") String bookId);

    @Select("SELECT id, isbn, area, status, loanDate, renewal " +
            "FROM bookitem AS b " +
            "WHERE id IN(" +
            "SELECT distinct bookId FROM user_favor WHERE userId=#{userId} AND isDel=0 " +
            ")")
    List<Bookitem> selectByUserId(@Param("userId") String userId);

    @Select("SELECT b.id, b.isbn, b.area, b.status, b.loanDate, b.renewal, bm.name, bm.author, bm.press " +
            "FROM bookitem AS b " +
            "LEFT JOIN book AS bm " +
            "ON b.isbn=bm.isbn " +
            "WHERE id IN( " +
            "SELECT distinct bookId FROM user_favor WHERE userId=#{userId} AND isDel=0)")
    List<FavorBookListDto> userFavorList(@Param("userId") String userId);
}
