package com.khushi.smart_interview_management.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.khushi.smart_interview_management.entity.User;
import com.khushi.smart_interview_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khushi.smart_interview_management.enums.UserRole;

@Service       //This class contains business logic
public class UserService {
    @Autowired      //Create the object automatically and inject it here
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //Parameterized Constructor
    public UserService(UserRepository userRepository) {     
        this.userRepository = userRepository;
    }

    //POST/SAVE user
    public User saveUser(User users) {   
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return userRepository.save(users);
    }

    //GET all users
    public List<User> getAllUsers() {      
        return userRepository.findAll();
    }

    //UPDATE/PUT user by id
    public User updateUser(Long id, User updatedUser) {
        User users = userRepository.findById(id).orElseThrow();
        users.setName(updatedUser.getName());
        users.setEmail(updatedUser.getEmail());
        users.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        users.setRole(updatedUser.getRole());
        return userRepository.save(users);
    }

    //DELETE user by id
    public void deleteUser(Long id) {      
       userRepository.deleteById(id);
    }

    //GET user by id
    public User getUserById(Long id) {      
       return userRepository.findById(id).orElseThrow();
    }

    //GET all users
    public List<User> saveAllUsers(List<User> users){
       return userRepository.saveAll(users);
    }

    //SEARCH
    public List<User> searchRole(UserRole role){
        return userRepository.findByRole(role);
    }
}
