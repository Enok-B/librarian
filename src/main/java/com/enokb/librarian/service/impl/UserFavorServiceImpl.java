package com.enokb.librarian.service.impl;

import com.enokb.librarian.dto.userfavor.FavorBookListDto;
import com.enokb.librarian.generate.model.UserFavor;
import com.enokb.librarian.mapper.UserFavorExtMapper;
import com.enokb.librarian.service.IUserFavorService;
import com.enokb.librarian.utils.IDUtil;
import com.enokb.librarian.utils.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserFavorServiceImpl implements IUserFavorService {

    @Autowired
    private UserFavorExtMapper userFavorExtMapper;

    @Override
    public boolean favorBook(String userId, String bookId, boolean isFavor) {
        if (!isFavor) {
            return userFavorExtMapper.deleteRecord(userId, bookId) >= 0;
        }
        UserFavor userFavor = new UserFavor(IDUtil.newId(), userId, bookId, !isFavor);
        if (userFavorExtMapper.insertIfNotExistRecord(userFavor) > 0) {
            return true;
        }
        return userFavorExtMapper.updateRecord(userId, bookId) > 0;
    }

    @Override
    public List<FavorBookListDto> listFavor(String userId) {
        return ListUtil.copyListProperties(userFavorExtMapper.userFavorList(userId)
                , new ArrayList<>(), FavorBookListDto.class);
    }
}
