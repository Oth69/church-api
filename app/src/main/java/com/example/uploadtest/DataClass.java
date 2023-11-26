package com.example.uploadtest;

public class DataClass {
    private String dataTitle;
    private String dataClockIN;
    private String dataClockOut;
    private String dataImage;
    private String key;
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getDataTitle() {
        return dataTitle;
    }
    public String getDataClockIN() {
        return dataClockIN;
    }
    public String getDataClockOut() {
        return dataClockOut;
    }
    public String getDataImage() {
        return dataImage;
    }
    public DataClass(String dataTitle, String dataClockIN, String dataClockOut, String dataImage) {
        this.dataTitle = dataTitle;
        this.dataClockIN = dataClockIN;
        this.dataClockOut = dataClockOut;
        this.dataImage = dataImage;
    }
    public DataClass(){
    }
}
