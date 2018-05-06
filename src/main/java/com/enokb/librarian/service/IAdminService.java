package com.enokb.librarian.service;

import com.enokb.librarian.dto.book.BookBorrowDto;

public interface IAdminService {
    BookBorrowDto borrow(String userIdentity, String bookItemId, String operator);
    boolean revert(String userIdentity, String bookItemId, String operator);
    boolean confirmAppointment(String bookItemId);
}
