package com.example.happy_tummy;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CartDatabase extends AppCompatActivity {
    public static List<Sandwich> sandwichList = new ArrayList<>();
    public static String address = "";

    public void changeTheCurrentSandwich(int position, Context context){
        Home.passSandwich = sandwichList.get(position);
        Intent intent = new Intent(context,BreadSelection.class);
        startActivity(intent);
    }
}
