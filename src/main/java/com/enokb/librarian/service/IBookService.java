package com.enokb.librarian.service;

import com.enokb.librarian.domain.BookDomain;
import com.enokb.librarian.dto.book.BookDto;
import com.enokb.librarian.dto.book.BookResultDto;
import com.enokb.librarian.dto.book.BookSearchDto;
import com.enokb.librarian.dto.book.BookSearchResultDto;
import com.enokb.librarian.model.BookSearchModel;

import java.util.List;

public interface IBookService {
    List<BookSearchResultDto> searchBook(BookSearchModel bookSearchModel);
}
