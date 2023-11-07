package com.subway.system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stations")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String name_en;
    private String img1;
    private String img2;
    private String img3;
    private int line_id;
    private int num_of_sec;
    private int year;

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
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

    public String getNameEn() {
        return name_en;
    }

    public String getImg1() {
        return img1;
    }

    public String getImg2() {
        return img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setId (int n) {
        this.id = n;
    }

    public void setYear (int n) {
        this.year = n;
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

    public void setNameEn (String s) {
        this.name_en = s;
    }

    public void setImg1 (String s) {
        this.img1 = s;
    }

    public void setImg2 (String s) {
        this.img2 = s;
    }

    public void setImg3 (String s) {
        this.img3 = s;
    }

    public void setStation (int id, String name, int num_of_sec, int line_id, String img1, String img2, String img3, int year) {
        setId(id);
        setName(name);
        setLine_id(line_id);
        setNum_of_sec(num_of_sec);
        setImg1(img1);
        setImg2(img2);
        setImg3(img3);
        setYear(year);
    }
}
