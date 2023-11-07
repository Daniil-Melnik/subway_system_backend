package com.subway.system.util_classes;

public class Localed_Station {
    private int id;
    private String name;
    private int line_id;
    private int num_of_sec;
    private String img1;
    private String img2;
    private String img3;
    private int year;

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

    public void setLine_id (int n) {
        this.line_id = n;
    }

    public void setNum_of_sec (int n) {
        this.num_of_sec = n;
    }

    public void setName (String s) {
        this.name = s;
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

    public void setYear (int n) {
        this.year = n;
    }

    public int getYear() {
        return year;
    }


    public Localed_Station(int id, String name, int num_of_sec, int line_id, String img1, String img2, String img3, int year) {
        this.id = id;
        this.name = name;
        this.num_of_sec= num_of_sec;
        this.line_id = line_id;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.year = year;
    }
}
