package com.enokb.librarian.service.impl;

import com.enokb.librarian.domain.BookDomain;
import com.enokb.librarian.dto.book.BookSearchResultDto;
import com.enokb.librarian.mapper.BookMapper;
import com.enokb.librarian.model.BookSearchModel;
import com.enokb.librarian.service.IBookService;
import com.enokb.utils.ListUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookSearchResultDto> searchBook(BookSearchModel bookSearchModel) {
        List<BookDomain> bookDomains = bookMapper.searchBook(bookSearchModel);
        if (ListUtil.isNotEmpty(bookDomains)) {
            List<BookSearchResultDto> bookSearchResultDtos = new ArrayList<>();
            bookDomains.forEach(domain -> {
                BookSearchResultDto bookSearchResultDto = new BookSearchResultDto();
                BeanUtils.copyProperties(domain, bookSearchResultDto);
                bookSearchResultDtos.add(bookSearchResultDto);
            });
            return bookSearchResultDtos;
        }
        return null;
    }
}
