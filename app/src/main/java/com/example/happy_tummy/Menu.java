package com.example.happy_tummy;

import com.example.happy_tummy.Ingredients.Ingredient;


import java.util.ArrayList;
import java.util.List;

public class Menu{

    static List<Ingredient> breadList;
    static List<Ingredient> addOnList;
    static List<Ingredient> sauceList;
    static List<Ingredient> veggieList;

    public Menu(){
        breadList = new ArrayList<>();
        addOnList = new ArrayList<>();
        sauceList = new ArrayList<>();
        veggieList= new ArrayList<>();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                new FirebaseDataPopulate();
            }
        });
        thread.start();
    }



}