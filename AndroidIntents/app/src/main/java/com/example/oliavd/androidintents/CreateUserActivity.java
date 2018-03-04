package com.example.oliavd.androidintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class CreateUserActivity extends AppCompatActivity {

    private EditText userName;
    private boolean male;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user_activity);
        userName = findViewById(R.id.editText);
        final RadioGroup rg = findViewById(R.id.user_name);


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.male:
                        male = true;

                        break;
                    case R.id.female:
                        male = false;

                        break;
                }

                System.out.println(male);


            }


        });
    }


    public void onClick(View view) {
        finish();
    }

    @Override
    public void finish() {

        //on finish, create new intent and send data to callee activity
        Intent intent = new Intent();
        intent.putExtra(User.USER_NAME, userName.getText().toString());
        intent.putExtra(User.USER_GENDER, male);
        setResult(RESULT_OK, intent);

        super.finish();
    }

}

