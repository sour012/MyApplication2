package com.example.myapplication2;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {

    private int scoreTeamA = 0;
    private int scoreTeamB = 0;


    private TextView scoreATextView;
    private TextView scoreBTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setupButton(R.id.btnA3, 3, true);
        setupButton(R.id.btnA2, 2, true);
        setupButton(R.id.btnA1, 1, true);


        setupButton(R.id.btnB3, 3, false);
        setupButton(R.id.btnB2, 2, false);
        setupButton(R.id.btnB1, 1, false);



        resetButton.setOnClickListener(v -> resetScores());
    }

    private void resetScores() {
    }

    private void setupButton(int btnA3, int i, boolean b) {
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);





    }
}
