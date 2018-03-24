package com.enokb.librarian.service;

import com.enokb.librarian.dto.book.BookItemResultDto;

import java.util.List;

public interface IUserFavorService {
    boolean favorBook(String userId, String bookId, boolean isFavor);
    List<BookItemResultDto> listFavor(String userId);
}
