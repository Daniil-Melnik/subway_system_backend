package com.subway.system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String psw;

    private int isLogged;

    public int getId() {
        return id;
    }

    public int getIL() {
        return isLogged;
    }

    public String getEmail() {
        return email;
    }

    public String getPsw() {
        return psw;
    }

    public void setEmail (String s) {
        this.email = s;
    } 
     
    public void setId (int n) { 
        this.id = n;
    }

     public void setIL (int n) { 
        this.isLogged = n;
    }

    public void setPsw (String s) {
        this.psw = s;
    }

    public User(String email, String psw, int id, int il) {
        this.id = id;
        this.email = email;
        this.psw = psw;
        this.isLogged = il;
    }
    public User() {}
}
