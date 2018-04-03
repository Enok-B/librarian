package com.enokb.librarian.service;

import com.enokb.librarian.dto.userfavor.FavorBookListDto;

import java.util.List;

public interface IUserFavorService {
    boolean favorBook(String userId, String bookId, boolean isFavor);
    List<FavorBookListDto> listFavor(String userId);
}
