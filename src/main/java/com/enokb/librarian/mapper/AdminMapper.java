package com.enokb.librarian.mapper;

import com.enokb.librarian.domain.AdminDomain;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface AdminMapper {

    @Delete({
            "delete from admin",
            "where amdim_Id = #{amdimId,jdbcType=INTEGER}"
    })
    int deleteById(Integer amdimId);

    @Insert({
            "insert into admin (amdim_Id, name, ",
            "password, permission, ",
            "area)",
            "values (#{amdimId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
            "#{password,jdbcType=VARCHAR}, #{permission,jdbcType=BIT}, ",
            "#{area,jdbcType=INTEGER})"
    })
    int insert(AdminDomain record);

    @Select({
            "select",
            "amdim_Id, name, password, permission, area",
            "from admin",
            "where amdim_Id = #{amdimId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "amdim_Id", property = "amdimId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
            @Result(column = "permission", property = "permission", jdbcType = JdbcType.BIT),
            @Result(column = "area", property = "area", jdbcType = JdbcType.INTEGER)
    })
    AdminDomain selectById(Integer amdimId);

    @Update({
            "update admin",
            "set name = #{name,jdbcType=VARCHAR},",
            "password = #{password,jdbcType=VARCHAR},",
            "permission = #{permission,jdbcType=BIT},",
            "area = #{area,jdbcType=INTEGER}",
            "where amdim_Id = #{amdimId,jdbcType=INTEGER}"
    })
    int updateById(AdminDomain record);
}