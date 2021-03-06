package com.enokb.librarian.mapper;

import com.enokb.librarian.domain.UserDomain;
import com.enokb.librarian.generate.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface UserExtMapper {

    @Select({
            "select",
            "id, identity, username, password, grade, quota, borrowed, credit",
            "from user",
            "where username = #{username,jdbcType=VARCHAR}"
    })
    User selectByName(String username);

    @Select({
            "select",
            "id, identity, username, password, grade, quota, borrowed, credit",
            "from user",
            "where identity = #{identity,jdbcType=VARCHAR}"
    })
    User selectByIdentity(String identity);

    @Select({
            "select",
            " u.id, u.identity, u.username, u.password, u.grade, u.quota, u.borrowed, u.credit, r.id, r.name",
            " from user as u",
            " LEFT JOIN role_user as sru on u.id = sru.userId",
            " LEFT JOIN role as r on sru.roleId = r.id",
            "where identity = #{identity,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "identity", property = "identity", jdbcType = JdbcType.VARCHAR),
            @Result(column = "username", property = "username", jdbcType = JdbcType.VARCHAR),
            @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
            @Result(column = "grade", property = "grade", jdbcType = JdbcType.VARCHAR),
            @Result(column = "quota", property = "quota", jdbcType = JdbcType.INTEGER),
            @Result(column = "borrowed", property = "borrowed", jdbcType = JdbcType.INTEGER),
            @Result(column = "credit", property = "credit", jdbcType = JdbcType.INTEGER),
            @Result(property = "roles", column = "id", many = @Many(select = "com.enokb.librarian.mapper.RoleExtMapper.selectRolesByUserId"))
    })
    UserDomain loginByIdentity(String identity);
}
