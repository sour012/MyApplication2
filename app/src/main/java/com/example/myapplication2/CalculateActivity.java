package com.example.myapplication2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculateActivity extends AppCompatActivity {
    private double rate;
    private EditText inputRmb;
    private TextView resultView;
    private Button calculateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        rate = getIntent().getDoubleExtra("rate", 0);
        inputRmb = findViewById(R.id.input_rmb);
        resultView = findViewById(R.id.result);
        calculateBtn = findViewById(R.id.calculate_btn);

        calculateBtn.setOnClickListener(v -> {
            String rmbStr = inputRmb.getText().toString();
            if (!rmbStr.isEmpty()) {
                double rmb = Double.parseDouble(rmbStr);
                double foreignCurrency = rmb / rate;
                resultView.setText(String.format("%.2f", foreignCurrency));
            }
        });
    }
}