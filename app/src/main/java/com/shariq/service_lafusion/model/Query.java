package com.shariq.service_lafusion.model;

public class Query {
    private int id;
    private String title;
    private String  description;
    private int imageId;
    private int sptype[];

    public int[] getSptype() {
        return sptype;
    }

    public void setSptype(int[] sptype) {
        this.sptype = sptype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
