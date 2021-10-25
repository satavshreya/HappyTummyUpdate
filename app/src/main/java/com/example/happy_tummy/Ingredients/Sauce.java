package com.example.happy_tummy.Ingredients;

import com.example.happy_tummy.CartDatabase;

public class Sauce implements Ingredient {

    String name;
    String image;
    int price;
    int quantity;
    boolean selected;

    @Override
    public void addToCart() {
        this.selected = true;
    }

    @Override
    public void removeFromCart() {
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

    public int getQuantity(){
        return this.quantity;
    }

    public Sauce(String name, String image, int price) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = 0;
    }
}
