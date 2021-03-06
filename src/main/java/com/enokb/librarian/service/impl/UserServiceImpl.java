package com.enokb.librarian.service.impl;

import com.enokb.librarian.config.exception.IncorrectStatusException;
import com.enokb.librarian.config.exception.UserExistException;
import com.enokb.librarian.domain.UserDomain;
import com.enokb.librarian.dto.book.BookBorrowDto;
import com.enokb.librarian.dto.user.UserDto;
import com.enokb.librarian.enums.BookStatus;
import com.enokb.librarian.enums.UserRoles;
import com.enokb.librarian.generate.mapper.AppointmentMapper;
import com.enokb.librarian.generate.mapper.RoleUserMapper;
import com.enokb.librarian.generate.mapper.UserMapper;
import com.enokb.librarian.generate.model.Appointment;
import com.enokb.librarian.generate.model.Checkoutlog;
import com.enokb.librarian.generate.model.RoleUser;
import com.enokb.librarian.generate.model.User;
import com.enokb.librarian.mapper.BookItemExtMapper;
import com.enokb.librarian.mapper.CheckOutLogExtMapper;
import com.enokb.librarian.mapper.UserExtMapper;
import com.enokb.librarian.model.UserRegisterModel;
import com.enokb.librarian.service.IUserService;
import com.enokb.librarian.utils.BeanMapperUtil;
import com.enokb.librarian.utils.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018-03-19 16:20
 **/

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserExtMapper userExtMapper;

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private CheckOutLogExtMapper checkOutLogExtMapper;

    @Autowired
    private BookItemExtMapper bookItemExtMapper;

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    @Transactional
    public boolean newUser(UserRegisterModel userDto, int credit, int quota, UserRoles role) {
        if (userExtMapper.selectByIdentity(userDto.getIdentity()) != null) {
            throw new UserExistException("identity:" + userDto.getIdentity());
        }

        User userDomain = new User(IDUtil.newId(), userDto.getIdentity(),
                userDto.getUsername(), encoder.encode(userDto.getPassword()), userDto.getGrade(),
                quota, 0, credit);
       return userMapper.insert(userDomain) ==1
               && roleUserMapper.insert(new RoleUser(IDUtil.newId(),
               userDomain.getId(), role.getId())) == 1;
    }

    @Override
    public UserDto userInfo(String identity) {
        UserDomain userDomain = userExtMapper.loginByIdentity(identity);
        return BeanMapperUtil.createAndCopyProperties(userDomain, UserDto.class);
    }

    @Override
    @Transactional
    public boolean newAdmin(UserRegisterModel userDto) {
        if (userExtMapper.selectByIdentity(userDto.getIdentity()) != null) {
            throw new UserExistException("identity:" + userDto.getIdentity());
        }
        User userDomain = new User(IDUtil.newId(), userDto.getIdentity(),
                userDto.getUsername(), encoder.encode(userDto.getPassword()), userDto.getGrade(),
                0, 0, 0);

        return userMapper.insert(userDomain) ==1
                && roleUserMapper.insert(new RoleUser(IDUtil.newId(),
                userDomain.getId(), UserRoles.ADMIN.getId())) == 1;
    }

    @Override
    public List<BookBorrowDto> borrowing(String userId) {
        return checkOutLogExtMapper.borrowing(userId);
    }

    @Override
    public boolean renewal(String userId, String bookItemId) {
        Checkoutlog log = checkOutLogExtMapper.logSelectByUserAndBook(userId, bookItemId);
        if (log != null && log.getStatus() != true)
            throw new IncorrectStatusException("not borrowed! bookItem:" + bookItemId);
        return bookItemExtMapper.updateRenewalBybookId(bookItemId) > 0;
    }

    @Override
    @Transactional
    public boolean appointment(String userId, String bookItemId) {
        return bookItemExtMapper.updateStatusById(BookStatus.APPOINTMENT_PENDING.getStatus(), bookItemId) > 0 &&
                appointmentMapper.insert(new Appointment(IDUtil.newId(), bookItemId, userId, new Date())) > 0;
    }
}
