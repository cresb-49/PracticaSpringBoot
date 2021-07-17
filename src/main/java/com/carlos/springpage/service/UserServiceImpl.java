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
        if(user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()){
            throw new Exception("El campo de confirmacion no debe estar vacio");
        }
        if(!(user.getPassword().equals(user.getConfirmPassword()))){
            throw new Exception("Password y confirmpassword no son iguales");
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

    @Override
    public User getUserById(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(()->new Exception("El usuario seleccionado no existe"));
    }
    @Override
    public User updateUser(User fromUser) throws Exception {
        User toUser = getUserById(fromUser.getId());
        mapUser(fromUser, toUser);
        userRepository.save(toUser);
        return null;
    }
    /**
     * Hacemos un merge del usuario sin tomar en cuenta la password
     * @param from
     * @param to
     */
    protected void mapUser(User from, User to){
        to.setUsername(from.getUsername());
        to.setFirstName(from.getFirstName());
        to.setLastName(from.getLastName());
        to.setEmail(from.getEmail());
        to.setRoles(from.getRoles());
    }
}
