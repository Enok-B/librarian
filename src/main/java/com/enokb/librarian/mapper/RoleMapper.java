package com.enokb.librarian.mapper;

import com.enokb.librarian.domain.RoleDomain;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleMapper {
    @Insert({
        "insert into role (id, name)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(RoleDomain record);

    @Select({
        "select",
        "id, name",
        "from role"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<RoleDomain> selectAll();
}