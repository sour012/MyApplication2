package com.example.myapplication2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.R;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText heightEditText = findViewById(R.id.h);
        EditText weightEditText = findViewById(R.id.w);
        TextView resultTextView = findViewById(R.id.t);
        Button calculateButton = findViewById(R.id.b);


        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String heightStr = heightEditText.getText().toString();
                String weightStr = weightEditText.getText().toString();


                if (!heightStr.isEmpty() && !weightStr.isEmpty()) {

                    float height = Float.parseFloat(heightStr);
                    float weight = Float.parseFloat(weightStr);
                    float bmi = weight / (height * height);


                    DecimalFormat df = new DecimalFormat("0.00");
                    String bmiStr = df.format(bmi);


                }
            }
        });
    }
}
