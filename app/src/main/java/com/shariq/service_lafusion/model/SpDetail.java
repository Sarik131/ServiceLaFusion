package com.shariq.service_lafusion.model;

public class SpDetail {


    private String name;
    private int id;
    private int experience;


    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public SpDetail(int id, String text, int experience) {

        this.id=id;
        this.name = text;
        this.experience=experience;
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

