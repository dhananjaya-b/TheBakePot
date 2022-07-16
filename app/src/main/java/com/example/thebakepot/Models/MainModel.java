package com.example.thebakepot.Models;

public class MainModel {
    int images;
    String name;
    String price;
    String description;







    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MainModel(int images, String name, String price, String description) {
        this.images = images;
        this.name = name;
        this.price = price;
        this.description = description;
    }


}
