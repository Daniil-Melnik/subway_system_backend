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

    public int getId() {
        return id;
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

    public void setPsw (String s) {
        this.psw = s;
    }


}
