package com.carlos.springpage.service;

import java.util.Optional;

import com.carlos.springpage.dto.ChangePasswordForm;
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
    @Override
    public void deleteUser(Long id) throws Exception{
        User user = getUserById(id);
        userRepository.deleteById(id);
    }

    @Override
    public User changePassword(ChangePasswordForm form) throws Exception{
		User storedUser = userRepository
				.findById( form.getId() )
				.orElseThrow(() -> new Exception("UsernotFound in ChangePassword -"+this.getClass().getName()));
		
		if( !(form.getCurrentPassword().equals(storedUser.getPassword()))) {
			throw new Exception("Current Password Incorrect.");
		}
		
		if ( form.getCurrentPassword().equals(form.getNewPassword())) {
			throw new Exception("New Password must be different than Current Password!");
		}
		
        System.out.println("Nueva:"+form.getNewPassword());
        System.out.println("Confirmacion:"+form.getConfirmPassword());
		if( !(form.getNewPassword().equals(form.getConfirmPassword()))) {
			throw new Exception("New Password and Confirm Password does not match!");
		}
		
		storedUser.setPassword(form.getNewPassword());
		return userRepository.save(storedUser);
	}
}
