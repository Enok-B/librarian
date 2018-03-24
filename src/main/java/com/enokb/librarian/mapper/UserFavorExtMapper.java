package com.enokb.librarian.mapper;

import com.enokb.librarian.generate.model.UserFavor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;

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
}
