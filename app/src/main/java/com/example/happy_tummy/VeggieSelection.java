package com.example.happy_tummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Selection;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.happy_tummy.Ingredients.Bread;
import com.example.happy_tummy.Ingredients.Veggie;

public class VeggieSelection extends AppCompatActivity {

    Sandwich sandwich = Home.passSandwich;
    Button prev,next;
    public static Menu menu = BreadSelection.menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veggie_selection);

        ListView gridView = findViewById(R.id.menu_veggie_view);
        GridAdapter gridAdapter = new GridAdapter(this, menu.veggieList,sandwich,"veggie");
        gridView.setAdapter(gridAdapter);

        next = findViewById(R.id.next_veggie);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sandwich.veggies.size()==0){
                    Toast.makeText(VeggieSelection.this,"You will have to select at least one veggie",Toast.LENGTH_LONG).show();
                }else {
                    Intent goToVeggie = new Intent(VeggieSelection.this, SauceSelection.class);
                    startActivity(goToVeggie);
                }
            }
        });

        prev = findViewById(R.id.prev_veggie);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHome = new Intent(VeggieSelection.this, BreadSelection.class);
                startActivity(goToHome);
            }
        });

    }
}