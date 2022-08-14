package com.example.dao;


import com.example.models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJavaImpl implements UserDao {
    String url = "jdbc:postgresql:// my-database.cr9ubtmwagwv.us-east-2.rds.amazonaws.com/bankingapp";
    String username = "postgres";
    String password = "Shia8645!";



@Override 
public List <User> getAllUsers(){

    List <User> users = new ArrayList<>();

    try {
        Connection conn = DriverManager.getConnection(url, username,password);

        String sql = "select * from users";

        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            users.add(new User(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5)));

        }

        conn.close();
     
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}
    
@Override public User getUserByUsername(String username) {
    
    User user = null;
    
    //try with resources will close the object thats within the parenthesis
    try {
        Connection conn = DriverManager.getConnection(url, username,password);

        //sql that we will be executing
        String sql = "select * from users where username = ?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, username);

        //execute the SQL statement and return the result set into the variable rs
        ResultSet rs = ps.executeQuery();

        //iterate through the result set
        while(rs.next()){
            user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        }
        
        conn.close();

    } catch (SQLException e) {

    }

    return user;
}


@Override
public void createUser(User user) {
    
    try {
        Connection conn = DriverManager.getConnection(url, username,password);

        //sql that we will be executing
        String sql = "insert into users (username, password, firstname, lastname) values (?,?,?,?);";
        PreparedStatement ps = conn.prepareStatement(sql);

        //the parameterIndex is references what questionmark we want to put a value in for
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getFirstname());
        ps.setString(4, user.getLastname());

        ps.executeUpdate();

        conn.close();
        
    } catch (SQLException e) {
    
    }
}

}