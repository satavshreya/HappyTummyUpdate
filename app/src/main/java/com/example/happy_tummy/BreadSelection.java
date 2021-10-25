package com.example.happy_tummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.happy_tummy.Ingredients.Ingredient;

public class BreadSelection extends AppCompatActivity{
    public static Menu menu = Home.menu;
    Sandwich sandwich = Home.passSandwich;
    Button prev,next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_selection);

        ListView gridView = findViewById(R.id.menu_list_view);
        GridAdapter gridAdapter = new GridAdapter(this, menu.breadList,sandwich,"bread");
        gridView.setAdapter(gridAdapter);

        next = findViewById(R.id.next_bread);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToVeggie = new Intent(BreadSelection.this,VeggieSelection.class);
                startActivity(goToVeggie);
            }
        });

        prev = findViewById(R.id.prev_bread);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHome = new Intent(BreadSelection.this,Home.class);
                startActivity(goToHome);
            }
        });
    }
}