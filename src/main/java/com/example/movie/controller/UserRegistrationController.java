package com.example.movie.controller;


import com.example.movie.model.UserInfo;
import com.example.movie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserRegistrationController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<List<UserInfo>> getAllUsers(){
        try{
            List<UserInfo> userList = new ArrayList<>();
            userList = userRepository.findAll();
            return new ResponseEntity<>(userList, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserInfo> getUserById(@PathVariable("id") long id) {
        Optional<UserInfo> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<UserInfo> createUser(@RequestBody UserInfo user) {
        try {
            UserInfo selectedUser = (UserInfo) userRepository
                    .save(new UserInfo(user.getName(), user.getPhoneNumber(), user.getUserType(), user.getAddress(), user.getId(), user.getPassword()));
            return new ResponseEntity<>(selectedUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserInfo> updateUser(@PathVariable("id") long id, @RequestBody UserInfo user) {
        Optional<UserInfo> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            UserInfo selectedUser = userData.get();
            selectedUser.setName(user.getName());
            selectedUser.setPhoneNumber(user.getPhoneNumber());
            selectedUser.setUserType(user.getUserType());
            selectedUser.setAddress(user.getAddress());
            selectedUser.setId(user.getId());
            selectedUser.setPassword(user.getPassword());

            return new ResponseEntity<>(userRepository.save(selectedUser), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
        try {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
