package com.example.happy_tummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DealsOfTheDay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deals_of_the_day);
        View deals1 = findViewById(R.id.Deals);

        deals1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deals = new Intent(DealsOfTheDay.this,DealsOfTheDay.class);
                startActivity(deals);
            }
        });

        View home = findViewById(R.id.Home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home1 = new Intent(DealsOfTheDay.this,Home.class);
                startActivity(home1);
            }
        });
        View locateus = findViewById(R.id.Findus);
        locateus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home1 = new Intent(DealsOfTheDay.this,findus.class);
                startActivity(home1);
            }
        });
    }
}
