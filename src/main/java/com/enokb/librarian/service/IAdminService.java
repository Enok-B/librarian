package com.enokb.librarian.service;

import com.enokb.librarian.dto.book.BookBorrowDto;

import java.util.List;

public interface IAdminService {
    BookBorrowDto borrow(String userIdentity, String bookItemId, String operator);
    boolean revert(String userIdentity, String bookItemId, String operator);
    boolean confirmAppointment(String bookItemId);
    List<BookBorrowDto> appointmentQuery(Integer area);
}
