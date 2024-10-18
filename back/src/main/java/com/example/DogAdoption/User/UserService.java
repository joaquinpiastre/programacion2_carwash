package com.example.DogAdoption.User;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ArrayList<User> getUser() {
        return (ArrayList<User>) userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public User updateUser(User request, Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User userToSave = user.get();
            userToSave.setName(request.getName());
            userToSave.setEmail(request.getEmail());
            userToSave.setWeight(request.getWeight());
            userToSave.setHeight(request.getHeight());
            return userRepository.save(userToSave);
        } else {
            return null;
        }
    }
}