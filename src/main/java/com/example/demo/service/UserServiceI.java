package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserServiceI {

    //curd

    //CREATE
    User createUser(User user);

    //UPDATE

    User updateUser(User user, Long userId);


    //GET Single date

    User getSingleUser(Long userId) throws Exception;

    //GET All data

    List<User> getAllUsers();

    //DELETE

    void deleteUser(Long userId);


}
