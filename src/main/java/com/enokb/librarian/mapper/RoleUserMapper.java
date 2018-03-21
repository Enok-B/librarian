package com.enokb.librarian.mapper;

import com.enokb.librarian.domain.RoleUserDomain;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleUserMapper {
    @Delete({
        "delete from role_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into role_user (id, userId, ",
        "roleId)",
        "values (#{id,jdbcType=VARCHAR}, #{userid,jdbcType=VARCHAR}, ",
        "#{roleid,jdbcType=INTEGER})"
    })
    int insert(RoleUserDomain record);

    @Select({
        "select",
        "id, userId, roleId",
        "from role_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="userId", property="userid", jdbcType=JdbcType.VARCHAR),
        @Result(column="roleId", property="roleid", jdbcType=JdbcType.INTEGER)
    })
    RoleUserDomain selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, userId, roleId",
        "from role_user"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="userId", property="userid", jdbcType=JdbcType.VARCHAR),
        @Result(column="roleId", property="roleid", jdbcType=JdbcType.INTEGER)
    })
    List<RoleUserDomain> selectAll();

    @Update({
        "update role_user",
        "set userId = #{userid,jdbcType=VARCHAR},",
          "roleId = #{roleid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(RoleUserDomain record);
}