package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity5 extends AppCompatActivity {
private static final string TAG ="Rate";
TextView show;
private float dollarRate=0.1f;
private float euroRate=0.05f;
private float wonrRate=500f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);
        show = findViewById(R.id.rab_show);

    }

    public void click(View btn) {
        EditText input = findViewById(R.id.rmb);
        String inpstr = input.getText().toString();
        try {

            float rmb = Float.parseFloat(inpstr);
            float result = 0.0f;
            if (btn.getId() == R.id.btn_dollar) {
                result = rmb * dollarRate;
            } else if (btn.getId() == R.id.btn_euro) {
                result = rmb * euroRate;
            } else if (btn.getId() == R.id.btn_won) {
                result = rmb * wonrRate;
            }

            show.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "请输入正确数据", Toast.LENGTH_LONG).show();
        }
    }


    public void  click(View btn) {
        Intent config = new Intent(this,ConfigActivity.class);
        config.putExtra("dollar_rate_key",dollarRate);
        config.putExtra("euro_rate_key",euroRate);
        config.putExtra("wonr_rate_key",wonrRate);

   startActivity(config);
    }


}