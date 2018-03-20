package com.enokb.librarian.mapper;

import com.enokb.librarian.domain.UserDomain;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into user (id, studentId, ",
        "username, password, ",
        "grade, quota, borrowed, ",
        "credit, token)",
        "values (#{id,jdbcType=VARCHAR}, #{studentid,jdbcType=VARCHAR}, ",
        "#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{grade,jdbcType=VARCHAR}, #{quota,jdbcType=INTEGER}, #{borrowed,jdbcType=INTEGER}, ",
        "#{credit,jdbcType=INTEGER}, #{token,jdbcType=VARCHAR})"
    })
    int insert(UserDomain record);

    @Select({
        "select",
        "id, studentId, username, password, grade, quota, borrowed, credit, token",
        "from user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="studentId", property="studentid", jdbcType=JdbcType.VARCHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="grade", property="grade", jdbcType=JdbcType.VARCHAR),
        @Result(column="quota", property="quota", jdbcType=JdbcType.INTEGER),
        @Result(column="borrowed", property="borrowed", jdbcType=JdbcType.INTEGER),
        @Result(column="credit", property="credit", jdbcType=JdbcType.INTEGER),
        @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR)
    })
    UserDomain selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, studentId, username, password, grade, quota, borrowed, credit, token",
        "from user"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="studentId", property="studentid", jdbcType=JdbcType.VARCHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="grade", property="grade", jdbcType=JdbcType.VARCHAR),
        @Result(column="quota", property="quota", jdbcType=JdbcType.INTEGER),
        @Result(column="borrowed", property="borrowed", jdbcType=JdbcType.INTEGER),
        @Result(column="credit", property="credit", jdbcType=JdbcType.INTEGER),
        @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR)
    })
    List<UserDomain> selectAll();

    @Update({
        "update user",
        "set studentId = #{studentid,jdbcType=VARCHAR},",
          "username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "quota = #{quota,jdbcType=INTEGER},",
          "borrowed = #{borrowed,jdbcType=INTEGER},",
          "credit = #{credit,jdbcType=INTEGER},",
          "token = #{token,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(UserDomain record);
}