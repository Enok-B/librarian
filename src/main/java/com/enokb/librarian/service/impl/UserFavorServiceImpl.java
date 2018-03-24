package com.enokb.librarian.service.impl;

import com.enokb.librarian.service.IUserFavorService;
import org.springframework.stereotype.Service;

@Service
public class UserFavorServiceImpl implements IUserFavorService {
    @Override
    public boolean favorBook(String userId, String bookId, boolean isFavor) {
        return false;
    }
}
