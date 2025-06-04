package com.example.myapplication2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

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
public class RateListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        new FetchDataTask().execute("https://www.huilvbiao.com/bank/spdb");
    }

    private class FetchDataTask extends AsyncTask<String, Void, List<CurrencyRate>> {
        @Override
        protected List<CurrencyRate> doInBackground(String... urls) {
            try {
                Document doc = Jsoup.connect(urls[0]).get();
                return WebParser.parse(doc.html());
            } catch (Exception e) {

            }
        }

        @Override
        protected void onPostExecute(List<CurrencyRate> rates) {
            if (rates != null) {
                // 更新RecyclerView
                CurrencyAdapter adapter = new CurrencyAdapter(rates);
                recyclerView.setAdapter(adapter);
            }
        }
    }
}