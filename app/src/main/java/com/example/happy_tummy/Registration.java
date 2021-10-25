package com.example.happy_tummy;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class Registration extends AppCompatActivity {

    private EditText emailSignUp , usernameSignUp , passwordSignUp,phonenumber;
    private Button regBtn;
    private DBHELPER myDB;
    ImageView ImageviewProfilePicture;
    ActivityResultLauncher<Intent> activityResultLauncher2;
    ActivityResultLauncher<String> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ImageviewProfilePicture=findViewById(R.id.profile_image);
        ImageviewProfilePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseProfilePicture();
            }
        });
        //gallery
         activityResultLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri uri) {
                        ImageviewProfilePicture.setImageURI(uri);
                    }
                });
        //camera
        activityResultLauncher2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),new ActivityResultCallback<ActivityResult>(){
            public void onActivityResult(ActivityResult result){
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Bundle bundle = result.getData().getExtras();
                Bitmap bitmap = (Bitmap) bundle.get("data");
                ImageviewProfilePicture.setImageBitmap(bitmap);
                byte[] imagePP = convertImageviewtoByteArray(ImageviewProfilePicture,bitmap);


            }
        });

        emailSignUp = findViewById(R.id.regitseremail);
        usernameSignUp = findViewById(R.id.registername);
        passwordSignUp = findViewById(R.id.registerpassword);
        phonenumber = findViewById(R.id.registernumber);
        ImageviewProfilePicture = (ImageView) findViewById(R.id.profile_image);

        regBtn = findViewById(R.id.regbtn);

        myDB = new DBHELPER(this);
        insertUser();
    }

    private void insertUser(){
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean var = myDB.registerUser(usernameSignUp.getText().toString() , emailSignUp.getText().toString() , passwordSignUp.getText().toString(),phonenumber.getText().toString(),ImageviewProfilePicture);
                System.out.println(passwordSignUp.getText().toString()+"hello password sign up");
                if(var){
                    Toast.makeText(Registration.this, "User Registered Successfully !!", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(Registration.this, "Registration Error !!", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void chooseProfilePicture(){
        AlertDialog.Builder  builder = new AlertDialog.Builder(Registration.this);
        LayoutInflater inflator = getLayoutInflater();
        View diaglogView = inflator.inflate(R.layout.alert_dialog_resource_file,null);
        builder.setCancelable(true);
        builder.setView(diaglogView);

        ImageView imageviewcamera = diaglogView.findViewById(R.id.camera);
        ImageView imageviewgallery = diaglogView.findViewById(R.id.gallery);
//camera
        imageviewcamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera = new Intent();
                camera.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                activityResultLauncher2.launch(camera);


            }
        });
        //gallery
        imageviewgallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent();
                gallery.setAction(MediaStore.Images.Media.DATA);
                activityResultLauncher.launch("image/*");

            }
        });

        AlertDialog alertdialogprofilepicture = builder.create();
        alertdialogprofilepicture.show();
    }
    private byte[] convertImageviewtoByteArray(ImageView imageviewProfilePicture,Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,80,byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

}