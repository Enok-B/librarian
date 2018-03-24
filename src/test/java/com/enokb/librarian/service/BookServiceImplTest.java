package com.enokb.librarian.service;

import com.enokb.librarian.dto.book.BookSearchResultDto;
import com.enokb.librarian.enums.BookType;
import com.enokb.librarian.generate.model.Book;
import com.enokb.librarian.mapper.BookExtMapper;
import com.enokb.librarian.model.BookSearchModel;
import com.enokb.librarian.service.impl.BookServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BookServiceImpl.class})
public class BookServiceImplTest {

    @MockBean
    private BookExtMapper bookExtMapper;

    @Autowired
    private BookServiceImpl bookService;

    @Before
    public void setUp() throws Exception {
        given(bookExtMapper.searchBook(ArgumentMatchers.notNull())).willReturn(
                        mockSearchResult());
    }

    @Test
    public void searchBook() {
        List<BookSearchResultDto> result = bookService.searchBook(
                BookSearchModel.newBuilder().type(BookType.NOVEL.getType()).build());
        Assert.assertTrue(result.size() == 2);
        Assert.assertEquals("孙煜冰", result.get(0).getAuthor());
        Assert.assertEquals("林一", result.get(1).getAuthor());
    }

    private List<Book> mockSearchResult() {
        List<Book> bookDomains = new ArrayList<>();
        bookDomains.add(new Book("0001", "book1", new BigDecimal(100),
                1, "孙煜冰", "热干面出版社"));
        bookDomains.add(new Book("0002", "book2", new BigDecimal(200),
                1, "林一", "周黑鸭出版社"));
        return bookDomains;
    }
}