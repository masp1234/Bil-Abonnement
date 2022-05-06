package com.example.bilabonnement.services;

import com.example.bilabonnement.models.User;
import com.example.bilabonnement.repositories.UserRepository;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String username, String password) {
        User user = userRepository.findUser(username);
        if(user == null){
            return null;
        }
        if(user.getPassword().equals(password)){
            return user;
        }
        return null;
    }
}
