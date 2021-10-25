package com.example.happy_tummy.Ingredients;

public interface Ingredient {
    String getName();
    String getImage();
    int getPrice();
    void addToCart();
    void removeFromCart();

}
