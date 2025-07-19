package com.ms.user.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ms.user.models.UserModel;
import com.ms.user.producers.UserProducer;
import com.ms.user.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    final UserRepository userRepository;
    final UserProducer userProducer;

    public UserService(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public UserModel save(UserModel userModel) {
        userModel =  userRepository.save(userModel);
        userProducer.publishMessageEmail(userModel);
        return userModel;
    }
}
