package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText phone , account , amount;
    Button addbtn , viewbtn;
    database g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        account = findViewById(R.id.account);
        amount = findViewById(R.id.amount);
        addbtn = findViewById(R.id.addbtn);
        viewbtn = findViewById(R.id.viewbtn);
         g = new database(this);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();
                Integer p = Integer.valueOf(phone.getText().toString());
                Integer a = Integer.valueOf(account.getText().toString());
                Integer am = Integer.valueOf(amount.getText().toString());
                if(n.equals("")||p.equals("")||a.equals("")||am.equals("")){
                    Toast.makeText(MainActivity.this, "All The Feilds Are Required ", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean i = g.insert_data(n, p, a, am);

                }


            }
        });
    }
}