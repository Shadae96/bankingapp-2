package com.example.services;

import com.example.dao.UserDao;
import com.example.dao.UserDaoImpl;

import com.example.models.User;



public class UserService {


    UserDao userDao;

    public UserService(){
        this.userDao = new UserDaoImpl();
    }

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }


    public boolean validateCredentials (User credentials) {
        User userFromDB = UserDao.getUserByUsername(credentials.getUsername());

        if (userFromDB == null) {
            return false;

        }    
          
        if (userFromDB.getPassword().equals(credentials.getPassword())) {
            return true;
            
        }

        return false;

        }

        public User getUserGivenUsername(String username) {
            return UserDao.getUserByUsername(username);
            
        }

        public User createUser(User userToCreate){
            User userFromDB = userDao.getUserByUsername(userToCreate.getUsername());

            if (userFromDB ==null) {
                userDao.createUser(userToCreate);
                return userToCreate;
                
            }

            return null;
        }




    } 

