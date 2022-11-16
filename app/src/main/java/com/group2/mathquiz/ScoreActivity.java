package com.group2.mathquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreActivity extends AppCompatActivity {

    private TextView textViewAllClear;
    private TextView textViewScore;
    private ImageButton buttonMenu;
    private TextView textViewAwesome;

    private int score = 0;
    private String activityTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_score);

        Intent intent = getIntent();
        score = intent.getIntExtra(QuizActivity.EXTRA_SCORE, 0);
        activityTag = intent.getStringExtra(QuizActivity.EXTRA_ACTIVITY);

        setupUI();

        if (activityTag.equals("QuizActivity")) {
            textViewScore.setText(Integer.toString(score));

            int savedHighScore = getHighScore();

            if (score > savedHighScore) {
                textViewAwesome.setText("New Best!");
                updateHighScore();
            }
        } else {
            textViewAllClear.setText("Highest Score");
            textViewScore.setText(Integer.toString(score));
        }
    }

    private void setupUI() {
        textViewAllClear = findViewById(R.id.text_view_all_clear);
        textViewScore = findViewById(R.id.text_view_score);

        buttonMenu = findViewById(R.id.image_button_menu_icon);
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMainMenu();
            }
        });

        textViewAwesome = findViewById(R.id.text_view_awesome);
    }

    private void backToMainMenu() {
        Intent intent = new Intent(ScoreActivity.this, HomeScreenActivity.class);
        startActivity(intent);
        ScoreActivity.this.finish();
    }

    private int getHighScore() {
        SharedPreferences sharedPref = getSharedPreferences(QuizActivity.SHARED_PREFS, MODE_PRIVATE);
        int highScore = sharedPref.getInt(QuizActivity.KEY_HIGH_SCORE, 0);
        return highScore;
    }

    private void updateHighScore() {
        SharedPreferences prefs = getSharedPreferences(QuizActivity.SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(QuizActivity.KEY_HIGH_SCORE, score);
        editor.apply();
    }

    @Override
    public void onBackPressed() {
        backToMainMenu();
    }
}