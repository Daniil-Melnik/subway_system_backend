package com.subway.system;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Para {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int section_num;
    private int station_id;
    private String text;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSection_num() {
        return section_num;
    }

    public void setSection_num(int section_num) {
        this.section_num = section_num;
    }

    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPara (int id, int station_id, int section_num, String text){
        setId(id);
        setSection_num(section_num);
        setStation_id(station_id);
        setText(text);
    }

}
