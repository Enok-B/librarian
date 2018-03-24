package com.enokb.librarian.mapper;

import com.enokb.librarian.generate.model.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleExtMapper {

    @Select({"SELECT r.id,r.name",
            " FROM role as r",
            " INNER JOIN role_user as ru on r.id = ru.roleId",
            " WHERE ru.userId =#{userId}"})
    List<Role> selectRolesByUserId(@Param("userId") String userId);
}
