package com.subway.system.util_classes;

public class Article_Section {
    private String text;
    private String src;
    private String caption;
    private int sec_num;

    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getSec_num() {
        return sec_num;
    }

    public void setSec_num(int sec_num) {
        this.sec_num = sec_num;
    }

    public void setSection(String text, String src, String caption, int sec_num) {
        setSec_num(sec_num);
        setCaption(caption);
        setText(text);
        setSrc(src);
    }

    public Article_Section(String text, String src, String caption, int sec_num) {
        this.text = text;
        this.sec_num = sec_num;
        this.src= src;
        this.caption = caption;
    }
}
