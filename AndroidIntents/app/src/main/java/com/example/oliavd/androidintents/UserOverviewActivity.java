package com.example.oliavd.androidintents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UserOverviewActivity extends AppCompatActivity {

    public static final int SUB_ACTIVITY_CREATE_USER = 10, SUB_ACTIVITY_LEARN = 20;
    private User user;
    ImageView genderImg;
    TextView name;
    TextView skillPoint;
    int skillPointInteger = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_overview);

        /* TODO check persistence if user exists and load the existing one */

        boolean userExists = false;
        genderImg = (ImageView) findViewById(R.id.genderImage) ;
        name = findViewById(R.id.user_name);
        skillPoint = findViewById(R.id.skill_point);

        /*Create a new one if none exist (call subactivity CreateActivity*/
        if(!userExists){
            Intent intent = new Intent(this,CreateUserActivity.class);
            startActivityForResult(intent, SUB_ACTIVITY_CREATE_USER);
        }

    }

    public void onClick(View view){
        Intent intent = new Intent(this,LearningActivity.class);
        intent.putExtra("skillPoints",user.skillPoints);
        startActivityForResult(intent,SUB_ACTIVITY_LEARN);

    }

        /* Callback for started sub-activity */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){


        if (requestCode == SUB_ACTIVITY_CREATE_USER && resultCode == Activity.RESULT_OK){
            Bundle extras = data.getExtras();
            if (extras != null){
                String name = extras.getString(User.USER_NAME);
                boolean gender = extras.getBoolean(User.USER_GENDER);

                user = new User(name,gender);
                updateUserInterface();
            }
        }

        if(requestCode == SUB_ACTIVITY_LEARN && resultCode == RESULT_OK){
            if(data.hasExtra("skillLevel")){
                //TODO implement what to do with returned data
                skillPointInteger = data.getExtras().getInt("skillLevel");
                user.skillPoints = skillPointInteger;
                Toast.makeText(this,"New Skill Level: "+String.valueOf(skillPointInteger),Toast.LENGTH_SHORT).show();

                skillPoint.setText(String.valueOf(skillPointInteger));
            }
        }
    }

    private void updateUserInterface(){
        //TODO show the new user values in the UI (add skill level to it)

        if (user.gender){

            genderImg.setImageDrawable(getDrawable(R.drawable.ic_boy));
        }else{
            genderImg.setImageDrawable(getDrawable(R.mipmap.ic_launcher_foreground));
        }

        skillPoint.setText(String.valueOf(user.skillPoints));

        name.setText(user.name);
        Toast.makeText(this,"User: "+String.valueOf(user.name)+" Created",Toast.LENGTH_LONG).show();



    }



}
