package com.enokb.librarian.service;

import com.enokb.librarian.domain.AdminDomain;

public interface IAdminService {
    int deleteById(Integer amdimId);
    int insert(AdminDomain record);
    AdminDomain selectById(Integer amdimId);
    int updateById(AdminDomain record);
}
