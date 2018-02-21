package com.example.oliavd.tempconverter8480;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text =  findViewById(R.id.inputValue);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.button:
                RadioButton  celsiusButton = findViewById(R.id.radioButton0);
                RadioButton fahrenheitButton = findViewById(R.id.radioButton1);
                if (text.getText().length()==0){
                    Toast.makeText(this,"Please enter a valid number",Toast.LENGTH_LONG).show();
                    return;
                }

                float inputValue = Float.parseFloat(text.getText().toString());
                if(celsiusButton.isChecked()){
                    text.setText(String.valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));
                    celsiusButton.setChecked(false);
                    fahrenheitButton.setChecked(true);

                }else{
                    text.setText(String.valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)));
                    fahrenheitButton.setChecked(false);
                    celsiusButton.setChecked(true);
                }
                break;

        }
    }
}
