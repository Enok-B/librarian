package com.enokb.librarian.service.impl;

import com.enokb.librarian.config.exception.IncorrectStatusException;
import com.enokb.librarian.config.exception.NotAppointmentException;
import com.enokb.librarian.config.exception.OverQuotaException;
import com.enokb.librarian.config.exception.ResourceNotFoundException;
import com.enokb.librarian.dto.book.BookBorrowDto;
import com.enokb.librarian.enums.BookStatus;
import com.enokb.librarian.generate.mapper.*;
import com.enokb.librarian.generate.model.Book;
import com.enokb.librarian.generate.model.Bookitem;
import com.enokb.librarian.generate.model.Checkoutlog;
import com.enokb.librarian.generate.model.User;
import com.enokb.librarian.mapper.AppointmentExtMapper;
import com.enokb.librarian.mapper.BookItemExtMapper;
import com.enokb.librarian.mapper.CheckOutLogExtMapper;
import com.enokb.librarian.mapper.UserExtMapper;
import com.enokb.librarian.service.IAdminService;
import com.enokb.librarian.utils.BeanMapperUtil;
import com.enokb.librarian.utils.IDUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018/4/12 下午9:23
 **/

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private UserExtMapper userExtMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookitemMapper bookitemMapper;

    @Autowired
    private BookItemExtMapper bookItemExtMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private CheckoutlogMapper checkoutlogMapper;

    @Autowired
    private CheckOutLogExtMapper checkOutLogExtMapper;

    @Autowired
    private AppointmentExtMapper appointmentExtMapper;

    @Override
    @Transactional
    public BookBorrowDto borrow(String userIdentity, String bookItemId, String operator) {
        User user = userExtMapper.selectByIdentity(userIdentity);
        if (user == null)
            throw new ResourceNotFoundException("user:" + userIdentity);
        if (user.getBorrowed() >= user.getQuota())
            throw new OverQuotaException(userIdentity);

        Bookitem bookItem = bookitemMapper.selectByPrimaryKey(bookItemId);
        if (bookItem == null)
            throw new ResourceNotFoundException("bookItem:" + bookItemId);
        if (bookItem.getStatus() != BookStatus.REGULAR.getStatus() && bookItem.getStatus() != BookStatus.APPOINTMENT.getStatus())
            throw new IncorrectStatusException("bookItem:" + bookItemId);
        if (bookItem.getStatus() == BookStatus.APPOINTMENT.getStatus()) {
            String appointmentUser = appointmentExtMapper.appointmentUser(bookItemId);
            if (!userIdentity.equals(appointmentUser))
                throw new NotAppointmentException("bookItem:" + bookItemId);
        }


        Date now = new Date();

        Checkoutlog checkoutlog = new Checkoutlog();
        checkoutlog.setId(IDUtil.newId());
        checkoutlog.setBookid(bookItemId);
        checkoutlog.setUserid(user.getId());
        checkoutlog.setDate(now);
        checkoutlog.setStatus(true);
        checkoutlog.setOperator(operator);
        checkoutlogMapper.insert(checkoutlog);

        user.setBorrowed(user.getBorrowed() + 1);
        userMapper.updateByPrimaryKey(user);

        bookItem.setLoandate(now);
        bookItem.setLoanuserid(user.getId());
        bookItem.setStatus(BookStatus.BORROWED.getStatus());
        bookitemMapper.updateByPrimaryKey(bookItem);

        Book book = bookMapper.selectByPrimaryKey(bookItem.getIsbn());
        BookBorrowDto result = BeanMapperUtil.createAndCopyProperties(bookItem, BookBorrowDto.class);
        BeanUtils.copyProperties(book, result);
        result.setLoanDate(bookItem.getLoandate());
        return result;
    }

    @Override
    @Transactional
    public boolean revert(String userIdentity, String bookItemId, String operator) {
        User user = userExtMapper.selectByIdentity(userIdentity);
        if (user == null)
            throw new ResourceNotFoundException("user:" + userIdentity);
        user.setBorrowed(user.getBorrowed() - 1);
        return checkOutLogExtMapper.revert(bookItemId, operator) > 0 &&
                bookItemExtMapper.revert(bookItemId) > 0 &&
                userMapper.updateByPrimaryKey(user) > 0;
    }

    @Override
    public boolean confirmAppointment(String bookItemId) {
        return bookItemExtMapper.updateStatusById(BookStatus.APPOINTMENT.getStatus(), bookItemId) > 0;
    }

    @Override
    public List<BookBorrowDto> appointmentQuery(Integer area) {
        return bookItemExtMapper.listAppointment(area);
    }
}
