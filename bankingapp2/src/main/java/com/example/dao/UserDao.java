package com.example.dao;

import java.util.List;

import com.example.models.User;



public interface UserDao {

    List <User> getAllUsers();

   static User getUserByUsername(String username) {

    return null;
} 

    void createUser (User user);
    
}
