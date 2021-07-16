package com.carlos.springpage.service;

import java.util.Optional;

import com.carlos.springpage.entity.User;
import com.carlos.springpage.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    private boolean checkUsernameAvaible(User user) throws Exception{
        Optional<User> findUser = userRepository.findByUsername(user.getUsername());

        if(findUser.isPresent()){
            throw new Exception("El nombre de usuario ya esta en uso");
        }
        return true;
    }

    private boolean checkPasswordMatch(User user) throws Exception{
        if(!(user.getPassword().equals(user.getConfirmPassword()))){
            throw new Exception("Las passwords con coinciden");
        }
        return true;
    }
    @Override
    public User createUser(User user) throws Exception {
        if(checkUsernameAvaible(user)&&checkPasswordMatch(user)){
            user = userRepository.save(user);
        }
        return user;
    }
}
