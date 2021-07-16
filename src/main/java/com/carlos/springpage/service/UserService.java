package com.carlos.springpage.service;

import javax.validation.Valid;

import com.carlos.springpage.entity.User;

public interface UserService  {
    public Iterable<User> getAllUsers();

    public User createUser(User user) throws Exception;
}
