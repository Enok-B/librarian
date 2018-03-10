package com.enokb.librarian.mapper;

import com.enokb.librarian.domain.UserDomain;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @Delete({
        "delete from user",
        "where user_Id = #{userId,jdbcType=INTEGER}"
    })
    int deleteById(Integer userId);

    @Insert({
        "insert into user (user_Id, student_Id, ",
        "name, passwoed, ",
        "group, quota, borrwing, ",
        "credit)",
        "values (#{userId,jdbcType=INTEGER}, #{studentId,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{passwoed,jdbcType=VARCHAR}, ",
        "#{group,jdbcType=VARCHAR}, #{quota,jdbcType=INTEGER}, #{borrwing,jdbcType=INTEGER}, ",
        "#{credit,jdbcType=INTEGER})"
    })
    int insert(UserDomain record);

    @Select({
        "select",
        "user_Id, student_Id, name, passwoed, group, quota, borrwing, credit",
        "from user",
        "where user_Id = #{userId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="user_Id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="student_Id", property="studentId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="passwoed", property="passwoed", jdbcType=JdbcType.VARCHAR),
        @Result(column="group", property="group", jdbcType=JdbcType.VARCHAR),
        @Result(column="quota", property="quota", jdbcType=JdbcType.INTEGER),
        @Result(column="borrwing", property="borrwing", jdbcType=JdbcType.INTEGER),
        @Result(column="credit", property="credit", jdbcType=JdbcType.INTEGER)
    })
    UserDomain selectById(Integer userId);

    @Select({
            "select",
            "user_Id, student_Id, name, passwoed, group, quota, borrwing, credit",
            "from user",
            "where user_Name = #{userName,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="user_Id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="student_Id", property="studentId", jdbcType=JdbcType.INTEGER),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="passwoed", property="passwoed", jdbcType=JdbcType.VARCHAR),
            @Result(column="group", property="group", jdbcType=JdbcType.VARCHAR),
            @Result(column="quota", property="quota", jdbcType=JdbcType.INTEGER),
            @Result(column="borrwing", property="borrwing", jdbcType=JdbcType.INTEGER),
            @Result(column="credit", property="credit", jdbcType=JdbcType.INTEGER)
    })
    UserDomain selectByName(String userName);

    @Update({
        "update user",
        "set student_Id = #{studentId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "passwoed = #{passwoed,jdbcType=VARCHAR},",
          "group = #{group,jdbcType=VARCHAR},",
          "quota = #{quota,jdbcType=INTEGER},",
          "borrwing = #{borrwing,jdbcType=INTEGER},",
          "credit = #{credit,jdbcType=INTEGER}",
        "where user_Id = #{userId,jdbcType=INTEGER}"
    })
    int updateById(UserDomain record);
}