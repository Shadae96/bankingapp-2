package com.example.models;

public class User {

// Here we are defining our variables
private Integer id;
private String username = "";
private String password = "";
private String firstname = "";
private String lastname = "";

// Calling the U ser object and giving it input

public User(Integer id, String username, String password, String firstname, String lastname) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.firstname = firstname;
    this.lastname = lastname;
};


// creating getters and setters -- variables are private so we have to create public getters and setters to access the variables we created. 



public Integer getId() {
    return this.id;
}

public void setId(Integer id) {
    this.id = id;
}
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastnmae) {
        this.lastname = lastnmae;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", firstname='" + getFirstname() + "'" +
            ", lastname='" + getLastname() + "'" +
            "}";
    }

}