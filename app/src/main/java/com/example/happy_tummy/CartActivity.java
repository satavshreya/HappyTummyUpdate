package com.example.happy_tummy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.happy_tummy.Ingredients.Ingredient;

import org.w3c.dom.Text;

public class CartActivity extends AppCompatActivity {


    Dialog address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Button dialogTaker = findViewById(R.id.confirm_order);
        ListView cartView = findViewById(R.id.cartListView);
        Button addAnotherSandwich = findViewById(R.id.add_another_sandwich);
        CartAdapter cartAdapter = new CartAdapter(this, CartDatabase.sandwichList);
        cartView.setAdapter(cartAdapter);

        address=new Dialog(CartActivity.this);
        address.setContentView(R.layout.activity_adress_dialogbox);
        address.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        address.setCancelable(true);

        for(Sandwich sandwich : CartDatabase.sandwichList){
            sandwich.price = sandwich.bread.getPrice();
            for(Ingredient ingredient : sandwich.veggies){
                sandwich.price += ingredient.getPrice();
            }
            for(Ingredient ingredient : sandwich.sauces){
                sandwich.price += ingredient.getPrice();
            }
            for(Ingredient ingredient : sandwich.addOns){
                sandwich.price += ingredient.getPrice();
            }
        }

        dialogTaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                address.show();
                Button confrimAddress = address.findViewById(R.id.confirm_address);
                EditText editText = address.findViewById(R.id.address_text);
                confrimAddress.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CartDatabase.address = editText.getText().toString();
                        if (CartDatabase.address.length() >= 50) {
                            Intent intent = new Intent(CartActivity.this, BillITem.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(CartActivity.this,"Please Provide More info on address", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        addAnotherSandwich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this,Home.class);
                startActivity(intent);
            }
        });
    }

}