package com.enokb.librarian.service.impl;

import com.enokb.librarian.domain.AdminDomain;
import com.enokb.librarian.mapper.AdminMapper;
import com.enokb.librarian.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018-03-02 17:48
 **/
@Component
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int deleteById(Integer amdimId) {
        return adminMapper.deleteById(amdimId);
    }

    @Override
    public int insert(AdminDomain record) {
        return adminMapper.insert(record);
    }

    @Override
    public AdminDomain selectById(Integer amdimId) {
        return adminMapper.selectById(amdimId);
    }

    @Override
    public int updateById(AdminDomain record) {
        return adminMapper.updateById(record);
    }
}
