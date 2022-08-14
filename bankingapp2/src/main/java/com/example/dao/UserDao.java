package com.example.dao;

import java.util.List;

import com.example.models.User;



public interface UserDao {

    List <User> getAllUsers();

   User getUserByUsername(String username) {
        // TODO Auto-generated method stub
        return null;
    }

    void createUser (User user);
    
}
