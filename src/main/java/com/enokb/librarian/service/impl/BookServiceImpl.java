package com.enokb.librarian.service.impl;

import com.enokb.librarian.dto.book.BookSearchResultDto;
import com.enokb.librarian.generate.mapper.BookMapper;
import com.enokb.librarian.generate.mapper.BookitemMapper;
import com.enokb.librarian.generate.model.Book;
import com.enokb.librarian.generate.model.Bookitem;
import com.enokb.librarian.mapper.BookExtMapper;
import com.enokb.librarian.model.BookEntryModel;
import com.enokb.librarian.model.BookSearchModel;
import com.enokb.librarian.service.IBookService;
import com.enokb.librarian.utils.IDUtil;
import com.enokb.librarian.utils.ListUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookExtMapper bookExtMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookitemMapper bookitemMapper;

    @Override
    public List<BookSearchResultDto> searchBook(BookSearchModel bookSearchModel) {
        List<Book> bookDomains = bookExtMapper.searchBook(bookSearchModel);
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

    @Override
    @Transactional
    public boolean entryBook(BookEntryModel book, String userId, int area, int status) {
        return bookMapper.insert(new Book(book.getIsbn().replaceAll("-", ""), book.getName(),
                book.getPrice(), book.getType(), book.getAuthor(), book.getPress())) ==1 &&
                bookitemMapper.insert(new Bookitem(IDUtil.newId(), book.getIsbn(), area,
                        status, new Date(), null, null, true, userId)) ==1;
    }
}
