package com.example.oliavd.viewinteraction;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.RadioGroup;


public class CreateUserActivity extends AppCompatActivity {

    boolean male = true;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        final RadioGroup radioGroup = findViewById(R.id.gender);
        final RadioButton male_button = findViewById(R.id.male);
        final RadioButton female_button = findViewById(R.id.female);



        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override

            public void onCheckedChanged(RadioGroup group, int checkedId) {


                switch (checkedId){
                    case R.id.male:
                        male = true;
                        break;
                    case R.id.female:
                        male = false;
                        break;
                }


            }
        });


    }



    public void onClick(View view){
        EditText input = findViewById(R.id.userName);
        String string = input.getText().toString();
        String genderString = null;
        if (male){
             genderString = "male";
        }else{
             genderString = "female";
        }




        Toast.makeText(this,"User "+string+" created. Gender: "+genderString, Toast.LENGTH_LONG).show();
    }
}
