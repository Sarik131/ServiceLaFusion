package com.shariq.service_lafusion.model;

public class Category {


    private String name;
    private int id;



    public Category(int id, String text) {

     this.id=id;
        this.name = text;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

