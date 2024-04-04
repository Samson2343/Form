package com.example.web.services;

import com.example.web.model.User;
import com.example.web.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findByUserId(ObjectId id){
        return userRepository.findByuserid(id);
    }

    public User save(User user){
        return  userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
