package com.example.happy_tummy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.happy_tummy.Ingredients.Ingredient;

public class BillITem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_item);
        TextView totalPrice = findViewById(R.id.bill_total_amount);
        TextView billAddress = findViewById(R.id.bill_address);
        int totalAmount = 0;
        for(Sandwich sandwich : CartDatabase.sandwichList){
            totalAmount += (sandwich.price * sandwich.quantity);
        }
        totalPrice.setText(Integer.toString(totalAmount));
        billAddress.setText(CartDatabase.address);
        ListView billView = findViewById(R.id.bill_list_view);
        BillSandwichAdapter billAdapter = new BillSandwichAdapter(this, CartDatabase.sandwichList);
        billView.setAdapter(billAdapter);

    }
}