package com.ms.user.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.user.dtos.UserRecordDto;
import com.ms.user.models.UserModel;
import com.ms.user.services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserModel>> getAllUsers() {
        List<UserModel> users = userService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    

    @PostMapping("/users")
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecordDto userRecordDto) {
        var userModel = new UserModel();
        BeanUtils.copyProperties(userRecordDto, userModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }
}
