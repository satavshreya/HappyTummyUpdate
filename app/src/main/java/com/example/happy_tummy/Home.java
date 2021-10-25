package com.example.happy_tummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    public static Menu menu  = Login.menu;
    public static Sandwich passSandwich = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        View deals1 = findViewById(R.id.Deals);
        Button menucardbtn=findViewById(R.id.menucard);
        menucardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CartDatabase.sandwichList.size()>0){
                    if(CartDatabase.sandwichList.get(CartDatabase.sandwichList.size()-1).veggies.size()!=0){
                        CartDatabase.sandwichList.add(new Sandwich());
                    }
                }else{
                    CartDatabase.sandwichList.add(new Sandwich());
                }
                passSandwich = CartDatabase.sandwichList.get(CartDatabase.sandwichList.size()-1);
                Intent goToMenu = new Intent(Home.this, BreadSelection.class);
                startActivity(goToMenu);
            }
        });

        deals1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deals = new Intent(Home.this,DealsOfTheDay.class);
                startActivity(deals);
            }
        });

        View home = findViewById(R.id.Home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home1 = new Intent(Home.this,Home.class);
                startActivity(home1);
            }
        });

        View locateus = findViewById(R.id.Findus);
        locateus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home1 = new Intent(Home.this,findus.class);
                startActivity(home1);
            }
        });
    }
}