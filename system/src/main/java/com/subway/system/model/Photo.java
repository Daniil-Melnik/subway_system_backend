package com.subway.system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int section_num;
    private int stNum;
    private String src;
    private String caption;
    private String caption_en;

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
        return stNum;
    }

    public void setStation_id(int station_id) {
        this.stNum = station_id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getCaption() {
        return caption;
    }

    public String getCaptionEn() {
        return caption_en;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setCaptionEn(String caption) {
        this.caption_en = caption;
    }

    public void setPhoto (int id, int station_id, int section_num, String src, String caption){
        setId(id);
        setSection_num(section_num);
        setStation_id(station_id);
        setCaption(caption);
        setSrc(src);
    }
}
