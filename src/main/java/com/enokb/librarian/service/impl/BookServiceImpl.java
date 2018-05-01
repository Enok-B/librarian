package com.enokb.librarian.service.impl;

import com.enokb.librarian.config.exception.ResourceNotFoundException;
import com.enokb.librarian.dto.book.BookResultDto;
import com.enokb.librarian.dto.book.BookItemResultDto;
import com.enokb.librarian.generate.mapper.BookMapper;
import com.enokb.librarian.generate.mapper.BookitemMapper;
import com.enokb.librarian.generate.model.Book;
import com.enokb.librarian.generate.model.Bookitem;
import com.enokb.librarian.mapper.BookExtMapper;
import com.enokb.librarian.model.BookEntryModel;
import com.enokb.librarian.model.BookSearchModel;
import com.enokb.librarian.service.IBookService;
import com.enokb.librarian.utils.BeanMapperUtil;
import com.enokb.librarian.utils.IDUtil;
import com.enokb.librarian.utils.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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
    public List<BookResultDto> searchBook(BookSearchModel bookSearchModel) {
        bookSearchModel.setIsbn(StringUtils.isEmpty(bookSearchModel.getIsbn())
                ? null : bookSearchModel.getIsbn().replaceAll("-", ""));
        List<Book> bookDomains = bookExtMapper.searchBook(bookSearchModel);
        return ListUtil.copyListProperties(bookDomains, new ArrayList<>(), BookResultDto.class);
    }

    @Override
    public BookResultDto bookDetail(String isbn) {
        if (!StringUtils.isEmpty(isbn)){
            isbn = isbn.replaceAll("-", "");
        }
        List<Bookitem> source = bookExtMapper.bookDetail(isbn);
        Book book = bookMapper.selectByPrimaryKey(isbn);
        if (book == null) {
            throw new ResourceNotFoundException("could not find book, isbn : " + isbn);
        }
        BookResultDto bookDto = BeanMapperUtil.createAndCopyProperties(book, BookResultDto.class);
        bookDto.setItems(ListUtil.copyListProperties(source, new ArrayList<>(), BookItemResultDto.class));
        return bookDto;
    }

    @Override
    @Transactional
    public boolean entryBook(BookEntryModel book, String userId, int area, int status) {
        Book bookDomain = new Book(book.getIsbn().replaceAll("-",""), book.getName(),
                book.getPrice(), book.getType(), book.getAuthor(), book.getPress());
        int result = bookExtMapper.insertIfNotExistBook(bookDomain);
        if (result == 0) {
            result = bookMapper.updateByPrimaryKey(bookDomain);
        }
        return result == 1 &&
                bookitemMapper.insert(new Bookitem(IDUtil.newId(), book.getIsbn(), area,
                        status, new Date(), null, null, true, userId)) == 1;
    }
}
