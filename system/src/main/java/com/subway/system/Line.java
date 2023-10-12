package com.subway.system;

public class Line {
    private int id;
    private String name;
    private int num_of_st;
    private String color;
    private String abbr;

    public int getId() {
        return id;
    }

    public int getNumOfSt() {
        return num_of_st;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setId(int d) {
        this.id = d;
    }

    public void setNumOfSt(int d) {
        this.num_of_st = d;
    }

    public void setName(String s) {
        this.name = s;
    }

    public void setColor(String s) {
        this.color = s;
    }

    public void setAbbr(String s) {
        this.abbr = s;
    }

    public void setLine(int id, int num_of_st, String name, String color, String abbr) {
        setAbbr(abbr);
        setName(name);
        setId(id);
        setNumOfSt(num_of_st);
        setColor(color);
    }
}
