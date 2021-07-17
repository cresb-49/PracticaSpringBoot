package com.carlos.springpage.service;
import com.carlos.springpage.entity.User;

public interface UserService  {

    public Iterable<User> getAllUsers();
    public User createUser(User user) throws Exception;
    public User getUserById(Long id) throws Exception;
    public User updateUser(User user) throws Exception;
}
