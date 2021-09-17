package com.example.childvaccination;

public class InfoDetail {
    private String title, source;

    public InfoDetail (String title, String source){
        this.title = title;
        this.source = source;
    }
    public String getTitle(){ return title; }
    public void setTitle(String title) { this.title = title; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

}
