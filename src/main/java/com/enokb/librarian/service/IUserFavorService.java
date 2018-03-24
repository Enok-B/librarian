package com.enokb.librarian.service;

public interface IUserFavorService {
    boolean favorBook(String userId, String bookId, boolean isFavor);
}
