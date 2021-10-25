package com.example.happy_tummy;

import android.util.Log;

import androidx.annotation.NonNull;
import java.util.*;


import com.example.happy_tummy.Ingredients.AddOn;
import com.example.happy_tummy.Ingredients.Bread;
import com.example.happy_tummy.Ingredients.Ingredient;
import com.example.happy_tummy.Ingredients.Sauce;
import com.example.happy_tummy.Ingredients.Veggie;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class FirebaseDataPopulate {
    FirebaseDatabase database ;

    FirebaseDataPopulate(){
        this.database = FirebaseDatabase.getInstance();
        startPopulation();
    }

    private void startPopulation(){
        List<List<Ingredient>> menuList = new ArrayList<>();
        menuList.add(Menu.breadList);
        menuList.add(Menu.veggieList);
        menuList.add(Menu.addOnList);
        menuList.add(Menu.sauceList);

        DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference();
        dataRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for(DataSnapshot shots : snapshot.getChildren()){
                    for(DataSnapshot shot : shots.getChildren()){
                        String name = shot.child("name").getValue().toString();
                        int price = Integer.parseInt(Objects.requireNonNull(shot.child("price").getValue()).toString());
                        String image = shot.child("image").getValue().toString();
                        String key = "";
                        try {
                            key = shots.getKey();
                        }catch(Exception e){
                            Log.d("FireBasePopulate","Null Pointer Exception");
                        }
                        switch (key.toLowerCase()) {
                            case "bread":
                                menuList.get(0).add(new Bread(name, image, price));
                                break;
                            case "veggie":
                                menuList.get(1).add(new Veggie(name, image, price));
                                break;
                            case "addon":
                                menuList.get(2).add(new AddOn(name, image, price));
                                break;
                            case "sauces":
                                menuList.get(3).add(new Sauce(name, image, price));
                                break;
                            default:
                                break;
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

    }




}
