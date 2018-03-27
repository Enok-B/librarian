package com.enokb.librarian.service;

import com.enokb.librarian.dto.book.BookResultDto;
import com.enokb.librarian.model.BookEntryModel;
import com.enokb.librarian.model.BookSearchModel;

import java.util.List;

public interface IBookService {
    List<BookResultDto> searchBook(BookSearchModel bookSearchModel);
    BookResultDto bookDetail(String isbn);
    boolean entryBook(BookEntryModel book, String userId, int area, int status);
}
