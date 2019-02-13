package com.shariq.service_lafusion.model;

public class SpList {
    private int imageId;
    private String name;
    private int stars;
    private int amount;


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    private int categoryId;

    public SpList(int imageId, String text, int stars) {

        this.imageId = imageId;
        this.name = text;
        this.stars = stars;
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

    public int getStars() { return stars; }

    public void setStars(int stars) { this.stars = stars; }
}
