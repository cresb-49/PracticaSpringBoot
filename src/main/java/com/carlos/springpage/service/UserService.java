package com.carlos.springpage.service;
import com.carlos.springpage.dto.ChangePasswordForm;
import com.carlos.springpage.entity.User;

public interface UserService  {

    public Iterable<User> getAllUsers();
    public User createUser(User user) throws Exception;
    public User getUserById(Long id) throws Exception;
    public User updateUser(User user) throws Exception;
    public void deleteUser(Long id) throws Exception;
    public User changePassword(ChangePasswordForm form) throws Exception;
}
