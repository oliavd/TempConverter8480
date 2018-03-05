package com.example.oliavd.androidintents;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class LearningActivity extends AppCompatActivity {

    int skillLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);

        skillLevel = getIntent().getExtras().getInt("skillPoints",skillLevel);

        //TODO Transfer data back to UserOverview Activity (new skill point level)

        List<Integer> buttons = Arrays.asList(R.id.pad1,R.id.pad2,R.id.pad3,R.id.pad4,R.id.pad5,R.id.pad6,R.id.pad7,R.id.pad8,
                R.id.pad9,R.id.padDelete,R.id.pad0);

        for(Integer i:buttons){
            View b = findViewById(i);
            b.setOnClickListener(new padClick());
        }


    }





    @Override
    public void finish(){
        Intent intent = new Intent();
        //skillLevel = skillLevel+5;
        intent.putExtra("skillLevel",skillLevel);
        setResult(RESULT_OK,intent);
        super.finish();


    }

    private void padClicked(String pn){
        Toast.makeText(this, "You clicked on pad: "+pn, Toast.LENGTH_SHORT).show();

    }

    class padClick implements View.OnClickListener{
        @Override
        public void onClick(View v){
            TextView tv = (TextView)v;

            padClicked(tv.getText().toString());

        }
    }

}

