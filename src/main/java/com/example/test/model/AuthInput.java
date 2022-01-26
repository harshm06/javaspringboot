package com.example.test.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AuthInput {

    @Id
    private int id;
    private String username;
    private String password;
    private String roles;

        
    public AuthInput() 
    {
    }
    public AuthInput(int id, String username, String password, String roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getPassword() {
        return password;
    }
    public String getRoles() {
        return roles;
    }
    public void setRoles(String roles) {
        this.roles = roles;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
}
