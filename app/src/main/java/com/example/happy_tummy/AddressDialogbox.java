package com.example.happy_tummy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.internal.Objects;

public class AddressDialogbox extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adress_dialogbox);

        Button confirmAddress = findViewById(R.id.confirm_address);
        EditText editText = findViewById(R.id.address_text);
        confirmAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartDatabase.address = editText.getText().toString();
                Log.d("this address ",CartDatabase.address);
                if(CartDatabase.address.length()>50){
                    Intent intent = new Intent(AddressDialogbox.this, BillITem.class);
                    startActivity(intent);
                }else{

                }
            }
        });
    }
}