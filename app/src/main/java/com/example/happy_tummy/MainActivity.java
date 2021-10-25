package com.example.happy_tummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.getStarted);

        textView = findViewById(R.id.textView5);
        //textView.setText(Menu.breadList.get(0).getName());
        Toast t = Toast.makeText(this,"Executed",Toast.LENGTH_SHORT);
        t.show();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open();
            }
        });
    }
    public void open(){
        Intent intent = new Intent(this, ChooseSign.class);
        startActivity(intent);
    }
}