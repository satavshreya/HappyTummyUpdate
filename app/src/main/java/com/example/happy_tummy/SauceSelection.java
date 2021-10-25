package com.example.happy_tummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Selection;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.happy_tummy.Ingredients.AddOn;

public class SauceSelection extends AppCompatActivity {

    Sandwich sandwich = Home.passSandwich;
    Button next,prev;
    public static Menu menu = AddOnSelection.menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sauce_selection);

        ListView gridView = findViewById(R.id.menu_sauce_view);
        GridAdapter gridAdapter = new GridAdapter(this, menu.sauceList,sandwich,"sauce");
        gridView.setAdapter(gridAdapter);

        next = findViewById(R.id.next_sauce);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToVeggie = new Intent(SauceSelection.this,AddOnSelection.class);
                startActivity(goToVeggie);
            }
        });

        prev = findViewById(R.id.prev_sauce);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHome = new Intent(SauceSelection.this, VeggieSelection.class);
                startActivity(goToHome);
            }
        });

    }
}