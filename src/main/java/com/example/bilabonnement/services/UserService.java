package com.example.bilabonnement.services;

import com.example.bilabonnement.models.User;
import com.example.bilabonnement.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*Daniel
    * Martin
    * Danny*/
    public User login(String username, String password) {
        User user = userRepository.findUser(username);
        if(user == null || ! user.getPassword().equals(password)){
           user = null;
        }
        return user;
    }
}
