package com.example.happy_tummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Selection;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.happy_tummy.Ingredients.Bread;
import com.example.happy_tummy.Ingredients.Ingredient;

public class AddOnSelection extends AppCompatActivity {
    public static Menu menu = BreadSelection.menu;
    Sandwich sandwich = Home.passSandwich;
    Button next,prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_on_selection);


        ListView gridView = findViewById(R.id.menu_addon_view);
        GridAdapter gridAdapter = new GridAdapter(this, menu.addOnList,sandwich,"addon");
        gridView.setAdapter(gridAdapter);

        next = findViewById(R.id.next_addOn);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(Sandwich sandwich : CartDatabase.sandwichList){
                    sandwich.price = sandwich.bread.getPrice();
                    for(Ingredient ingredient : sandwich.addOns){
                        sandwich.price += ingredient.getPrice();
                    }
                    for(Ingredient ingredient : sandwich.sauces){
                        sandwich.price += ingredient.getPrice();
                    }
                    for(Ingredient ingredient : sandwich.veggies) {
                        sandwich.price += ingredient.getPrice();
                    }
                }


                Intent goToCartActivity = new Intent(AddOnSelection.this, CartActivity.class);
                startActivity(goToCartActivity);
            }
        });

        prev = findViewById(R.id.prev_addOn);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHome = new Intent(AddOnSelection.this, SauceSelection.class);
                startActivity(goToHome);
            }
        });

    }
}