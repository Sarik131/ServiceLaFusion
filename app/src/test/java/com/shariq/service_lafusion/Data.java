package com.shariq.service_lafusion;

import static org.junit.Assert.*;

public class Data {

    public int imageId;
    public String txt;

    Data(  String text,int imageId) {
        this.txt = text;
        this.imageId = imageId;

    }

    public int getImageId() {
        return imageId;
    }

    public String getTxt() {
        return txt;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}