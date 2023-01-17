package com.example.bankingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    private static final String dbname = "bank.db";
    public database(@Nullable Context context) {
        super(context, dbname , null , 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db ) {
        String q = "create table users (_id integer primary key autoincrement , name Text , phone Integer , account Integer , amount Integer )";
        db.execSQL(q);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists users");
        onCreate(db);


    }
    public boolean insert_data(String name , Integer phone , Integer account , Integer amount ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("name",name);
        c.put("phone",phone);
        c.put("account",account);
        c.put("amount",amount);
        long r = db.insert("users", null,c);
        if(r==-1)
            return false;
        else
            return true;

    }
}
