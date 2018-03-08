package com.enokb.librarian.service;

import com.enokb.librarian.domain.BookDomain;
import com.enokb.librarian.dto.book.BookDto;

import java.util.List;

public interface IBookService {
    List<BookDto> searchBook();
}
