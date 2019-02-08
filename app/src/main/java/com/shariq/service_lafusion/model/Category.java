package com.shariq.service_lafusion.model;

public class Category {

    private int imageId;
    private String name;
    private String id;



    public Category(int imageId, String text) {

        this.imageId = imageId;
        this.name = text;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

