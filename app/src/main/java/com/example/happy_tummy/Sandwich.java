package com.example.happy_tummy;

import com.example.happy_tummy.Ingredients.AddOn;
import com.example.happy_tummy.Ingredients.Bread;
import com.example.happy_tummy.Ingredients.Sauce;
import com.example.happy_tummy.Ingredients.Veggie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sandwich {
    String name;
    Bread bread;
    List<Sauce> sauces;
    List<AddOn> addOns;
    List<Veggie> veggies;
    int quantity = 1;
    int price;

    public Sandwich(){
        this.name = "";
        this.bread = (Bread) Menu.breadList.get(0);
        this.bread.addToCart();
        this.sauces = new ArrayList<>();
        this.addOns = new ArrayList<>();
        this.veggies = new ArrayList<>();
    }

    public void setBread(Bread bread){
        this.bread = bread;
    }
    public void addSauce(Sauce sauce){
        this.sauces.add(sauce);
    }
    public void addAddOns(AddOn addOn){
        this.addOns.add(addOn);
    }
    public void addVeggie(Veggie veggie){
        this.veggies.add(veggie);
    }

    public Bread getBread() {
        return bread;
    }


    public void increaseQuantity(){
        if(quantity<=10) {
            quantity++;
        }
    }
    public void decreaseQuantity(){
        if(quantity>=0){
            quantity--;
        }
    }
}
