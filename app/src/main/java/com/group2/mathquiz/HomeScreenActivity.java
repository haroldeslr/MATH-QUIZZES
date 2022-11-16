package com.group2.mathquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeScreenActivity extends AppCompatActivity {

    private final String HOME_SCREEN_ACTIVITY_TAG = "HomeScreenActivity";

    private Button buttonStartQuiz;
    private Button buttonHighScore;
    private Button buttonSettings;

    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home_screen);

        setupUI();

        //testEasyQuestions();
        //testMediumQuestions();
        //testHardQuestions();
    }

    private void setupUI() {
        buttonStartQuiz = findViewById(R.id.button_start_quiz);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreenActivity.this, DifficultyActivity.class);
                startActivity(intent);
            }
        });

        buttonHighScore = findViewById(R.id.button_high_score);
        buttonHighScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int highScore = getHighScore();
                Intent intent = new Intent(HomeScreenActivity.this, ScoreActivity.class);
                intent.putExtra(QuizActivity.EXTRA_SCORE, highScore);
                intent.putExtra(QuizActivity.EXTRA_ACTIVITY, HOME_SCREEN_ACTIVITY_TAG);
                startActivity(intent);
            }
        });

        buttonSettings = findViewById(R.id.button_setts);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreenActivity.this, Settings.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            HomeScreenActivity.this.finishAffinity();
        } else {
            Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis();
    }

    private int getHighScore() {
        SharedPreferences sharedPref = getSharedPreferences(QuizActivity.SHARED_PREFS, MODE_PRIVATE);
        int highScore = sharedPref.getInt(QuizActivity.KEY_HIGH_SCORE, 0);
        return highScore;
    }


    // Test Methods
    private void testEasyQuestions() {
        ArrayList<Question> easy = QuestionListGenerator.getEasyQuestionList();

        for (int i = 0; i < easy.size(); i++) {
            Log.i("HomeScreenActivity", i + 1 + ". ");
            Log.i("HomeScreenActivity", "Question: " + easy.get(i).getQuestion());
            Log.i("HomeScreenActivity", "Option 1: " + easy.get(i).getOption1());
            Log.i("HomeScreenActivity", "Option 2: " + easy.get(i).getOption2());
            Log.i("HomeScreenActivity", "Option 3: " + easy.get(i).getOption3());
            Log.i("HomeScreenActivity", "Option 4: " + easy.get(i).getOption4());
            Log.i("HomeScreenActivity", "AnsNr:  : " + easy.get(i).getAnswerNumber());
            Log.i("HomeScreenActivity", "Difficulty: " + easy.get(i).getDifficulty());
        }
    }

    private void testMediumQuestions() {
        ArrayList<Question> medium = QuestionListGenerator.getMediumQuestionList();

        for (int i = 0; i < medium.size(); i++) {
            Log.i("HomeScreenActivity", i + 1 + ". ");
            Log.i("HomeScreenActivity", "Question: " + medium.get(i).getQuestion());
            Log.i("HomeScreenActivity", "Option 1: " + medium.get(i).getOption1());
            Log.i("HomeScreenActivity", "Option 2: " + medium.get(i).getOption2());
            Log.i("HomeScreenActivity", "Option 3: " + medium.get(i).getOption3());
            Log.i("HomeScreenActivity", "Option 4: " + medium.get(i).getOption4());
            Log.i("HomeScreenActivity", "AnsNr:  : " + medium.get(i).getAnswerNumber());
            Log.i("HomeScreenActivity", "Difficulty: " + medium.get(i).getDifficulty());
        }
    }

    private void testHardQuestions() {
        ArrayList<Question> hard = QuestionListGenerator.getHardQuestionList();

        for (int i = 0; i < hard.size(); i++) {
            Log.i("HomeScreenActivity", i + 1 + ". ");
            Log.i("HomeScreenActivity", "Question: " + hard.get(i).getQuestion());
            Log.i("HomeScreenActivity", "Option 1: " + hard.get(i).getOption1());
            Log.i("HomeScreenActivity", "Option 2: " + hard.get(i).getOption2());
            Log.i("HomeScreenActivity", "Option 3: " + hard.get(i).getOption3());
            Log.i("HomeScreenActivity", "Option 4: " + hard.get(i).getOption4());
            Log.i("HomeScreenActivity", "AnsNr:  : " + hard.get(i).getAnswerNumber());
            Log.i("HomeScreenActivity", "Difficulty: " + hard.get(i).getDifficulty());
        }
    }
}