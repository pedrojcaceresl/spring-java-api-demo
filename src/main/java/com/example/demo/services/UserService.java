package com.example.demo.services;

import com.example.demo.models.UserModel;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public Optional<UserModel> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }

    public UserModel updateUser(long id, UserModel user) {
        Optional<UserModel> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            UserModel existingUser = userData.get();
            existingUser.setEmail(user.getEmail());
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
