package com.enokb.librarian.service;

import com.enokb.librarian.dto.book.BookBorrowDto;

public interface IAdminService {
    BookBorrowDto borrow(String userId, String bookItemId, String operator);
}