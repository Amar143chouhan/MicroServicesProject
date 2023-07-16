package com.userservice.service;

import com.userservice.entities.User;

import java.util.List;

public interface UserService
{

    //create user
     public User saveUser(User user);

    //getall user
    List<User> getAllUser();


    //get single user
    User getUser(String id );



}
