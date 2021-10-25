package com.example.happy_tummy.Ingredients;


import com.example.happy_tummy.CartDatabase;

public class Bread implements Ingredient {

    String name;
    String image;
    int price;
    boolean selected;

    public Bread(String name, String image, int price) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.selected = false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getImage() {
        return this.image;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public void addToCart() {
        this.selected = true;
    }

    @Override
    public void removeFromCart() {
        this.selected = false;
    }
}

