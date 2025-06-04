package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ConfigActivity extends AppCompatActivity {
    private EditText edDollar, edEuro, edWon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);


        edDollar = findViewById(R.id.ed_dollar);
        edEuro = findViewById(R.id.ed_euro);
        edWon = findViewById(R.id.ed_won);


        Intent intent = getIntent();
        edDollar.setText(String.valueOf(intent.getFloatExtra("dollar_rate", 0.1f)));
        edEuro.setText(String.valueOf(intent.getFloatExtra("euro_rate", 0.05f)));
        edWon.setText(String.valueOf(intent.getFloatExtra("won_rate", 500f)));
    }


    public void onSaveClick(View view) {
        try {
            float newDollar = Float.parseFloat(edDollar.getText().toString());
            float newEuro = Float.parseFloat(edEuro.getText().toString());
            float newWon = Float.parseFloat(edWon.getText().toString());


            Intent result = new Intent();
            result.putExtra("new_dollar_rate", newDollar);
            result.putExtra("new_euro_rate", newEuro);
            result.putExtra("new_won_rate", newWon);
            setResult(RESULT_OK, result);
            finish();
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "请输入有效汇率", Toast.LENGTH_SHORT).show();
        }
    }
}