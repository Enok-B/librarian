package com.enokb.librarian.service;

import com.enokb.librarian.dto.book.BookSearchResultDto;
import com.enokb.librarian.model.BookEntryModel;
import com.enokb.librarian.model.BookSearchModel;

import java.util.List;

public interface IBookService {
    List<BookSearchResultDto> searchBook(BookSearchModel bookSearchModel);
    boolean entryBook(BookEntryModel book, String userId, int area, int status);
}
