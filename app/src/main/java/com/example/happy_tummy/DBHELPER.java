package com.example.happy_tummy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ImageView;
import android.widget.Toast;

public class DBHELPER extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "USER1.db";
    private static final String TABLE_NAME = "USER_DATA";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "USERNAME";
    private static final String COL_3 = "EMAIL";
    private static final String COL_4 = "PASSWORD";
    private static final String COL_5 = "PHONENUMBER";
    private static final String COL_6 = "PP";
    SQLiteDatabase db ;

    public DBHELPER(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , USERNAME TEXT NOT NULL, EMAIL TEXT NOT NULL, PASSWORD TEXT NOT NULL,PHONENUMBER TEXT NOT NULL, PP BLOB NOT NULL )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean registerUser(String username, String email, String password, String number, ImageView PP) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2, username);
        values.put(COL_3, email);
        values.put(COL_4, password);
        values.put(COL_5, number);
        values.put(COL_6, String.valueOf(PP));

        long result = db.insert(TABLE_NAME, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean checkUser(String username, String password) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor resultSet = db.rawQuery("Select * from USER_DATA", null);

        resultSet.moveToFirst();
        String Username = resultSet.getString(1);

        String Password = resultSet.getString(3);
        System.out.println("The Username is "+Username+" It's Password is "+Password);
        if (Username.equals(username)) {
            if (Password.equals(password)) {
                return true;
            }
        }
        if (resultSet.getCount() > 1) {

            for (int i = 1; i < resultSet.getCount(); i++) {
                resultSet.moveToNext();
                Username = resultSet.getString(1);
                Password = resultSet.getString(3);
                System.out.println("The Username is "+Username+" It's Password is "+Password);
                if (username.equals(Username)) {
                    if (password.equals(Password)) {
                        return true;
                    } else {
                        System.out.println(Password+  "  password is incorrect");
                    }
                }
            }
        }

        System.out.println(Username+" username is incorrect mf");


        return false;

    }

}
