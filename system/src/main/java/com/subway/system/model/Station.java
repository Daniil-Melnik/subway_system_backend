package com.subway.system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int line_id;
    private int num_of_sec;

    public int getId() {
        return id;
    }

    public int getLine_id() {
        return line_id;
    }

    public int getNum_of_sec() {
        return num_of_sec;
    }

    public String getName() {
        return name;
    }

    public void setId (int n) {
        this.id = n;
    }

    public void setLine_id (int n) {
        this.line_id = n;
    }

    public void setNum_of_sec (int n) {
        this.num_of_sec = n;
    }

    public void setName (String s) {
        this.name = s;
    }

    public void setStation (int id, String name, int num_of_sec, int line_id) {
        setId(id);
        setName(name);
        setLine_id(line_id);
        setNum_of_sec(num_of_sec);
    }
}