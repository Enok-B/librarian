package com.enokb.librarian.service;

import com.enokb.librarian.dto.book.BookSearchResultDto;
import com.enokb.librarian.model.BookSearchModel;

import java.util.List;

public interface IBookService {
    List<BookSearchResultDto> searchBook(BookSearchModel bookSearchModel);
}
