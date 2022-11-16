package com.group2.mathquiz;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class DifficultyActivity extends AppCompatActivity {

    public static final String EXTRA_DIFFICULTY = "extraDifficulty";

    Button buttonEasy;
    Button buttonMedium;
    Button buttonHard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_difficulty);

        setupUI();
    }

    private void setupUI() {
        buttonEasy = findViewById(R.id.button_easy);
        buttonMedium = findViewById(R.id.button_medium);
        buttonHard = findViewById(R.id.button_hard);

        buttonEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DifficultyActivity.this, QuizActivity.class);
                intent.putExtra(EXTRA_DIFFICULTY, Question.EASY_MODE);
                startActivity(intent);
                DifficultyActivity.this.finish();
            }
        });

        buttonMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DifficultyActivity.this, QuizActivity.class);
                intent.putExtra(EXTRA_DIFFICULTY, Question.MEDIUM_MODE);
                startActivity(intent);
                DifficultyActivity.this.finish();
            }
        });

        buttonHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DifficultyActivity.this, QuizActivity.class);
                intent.putExtra(EXTRA_DIFFICULTY, Question.HARD_MODE);
                startActivity(intent);
                DifficultyActivity.this.finish();
            }
        });
    }
}