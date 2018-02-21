package com.example.oliavd.viewinteraction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);


    }

    public void onClick(View view){
        EditText input = findViewById(R.id.userName);
        String string = input.getText().toString();
        Toast.makeText(this,"User "+string+" created.", Toast.LENGTH_LONG).show();
    }
}
