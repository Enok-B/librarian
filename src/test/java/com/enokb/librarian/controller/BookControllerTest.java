package com.enokb.librarian.controller;

import com.enokb.librarian.dto.book.BookSearchDto;
import com.enokb.librarian.dto.book.BookSearchResultDto;
import com.enokb.librarian.model.BookSearchModel;
import com.enokb.librarian.service.IBookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BookController.class, secure = false)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IBookService ibookService;

    public void setUp() {
        given(ibookService.searchBook(ArgumentMatchers.any(BookSearchModel.class))).willReturn(mockSearchResult());
    }

    @Test
    public void searchBook() throws Exception {
        mockMvc.perform(post("/book/search").accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(new ObjectMapper().writeValueAsString(BookSearchDto.newBuilder()
                        .author("孙煜冰").build())))
                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    private List<BookSearchResultDto> mockSearchResult() {
        List<BookSearchResultDto> bookSearchResultDtos = new ArrayList<>();
        bookSearchResultDtos.add(BookSearchResultDto.newBuilder()
                .isbn("0001")
                .author("孙煜冰")
                .press("热干面出版社")
                .build());
        bookSearchResultDtos.add(BookSearchResultDto.newBuilder()
                .isbn("0002")
                .author("林一")
                .press("周黑鸭出版社")
                .build());
        return bookSearchResultDtos;
    }
}