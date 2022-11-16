package com.group2.mathquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    private final String QUIZ_ACTIVITY_TAG = "QuizActivity";

    public static final String SHARED_PREFS = "sharedPrefs";

    public static final String KEY_HIGH_SCORE = "keyHighScore";

    public static final String EXTRA_SCORE = "extraScore";
    public static final String EXTRA_ACTIVITY = "extraActivity";

    private TextView textViewCurrentScore;
    private TextView textViewQuestionCount;
    private TextView textViewDifficulty;
    private TextView textViewScoreAmount;
    private TextView textViewQuestion;
    private Button buttonOption1;
    private Button buttonOption2;
    private Button buttonOption3;
    private Button buttonOption4;
    private Button buttonConfirmAnswerNextQuestion;

    private ArrayList<Question> allQuestions = new ArrayList<>();

    private Question currentQuestion;
    private int questionCount = 1;
    private int  totalQuestions = 0;
    private int score = 0;
    private int selectedAnswer = 0;
    private boolean answered = false;

    private long backPressedTime;

    private ColorStateList defaultButtonTextColor;
    private ColorStateList grayButtonText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quiz);

        Intent intent = getIntent();
        String difficulty = intent.getStringExtra(DifficultyActivity.EXTRA_DIFFICULTY);

        setupUI();
        getAllQuestions(difficulty);
        startQuiz();
    }

    private void setupUI() {
        textViewCurrentScore = findViewById(R.id.text_view_current_score);
        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        textViewDifficulty = findViewById(R.id.text_view_difficulty);
        textViewScoreAmount = findViewById(R.id.text_view_score_amount);
        textViewQuestion = findViewById(R.id.text_view_question);

        buttonOption1 = findViewById(R.id.button_option1);
        buttonOption1.setOnClickListener(this);
        buttonOption2 = findViewById(R.id.button_option2);
        buttonOption2.setOnClickListener(this);
        buttonOption3 = findViewById(R.id.button_option3);
        buttonOption3.setOnClickListener(this);
        buttonOption4 = findViewById(R.id.button_option4);
        buttonOption4.setOnClickListener(this);
        buttonConfirmAnswerNextQuestion = findViewById(R.id.button_confirm_answer_next_question);
        buttonConfirmAnswerNextQuestion.setOnClickListener(this);

        defaultButtonTextColor = buttonOption1.getTextColors();
        grayButtonText = ContextCompat.getColorStateList(QuizActivity.this, R.color.gray_text_button);
    }

    private void getAllQuestions(String difficulty) {
        switch (difficulty) {
            case Question.EASY_MODE:
                allQuestions = QuestionListGenerator.getEasyQuestionList();
                break;
            case Question.MEDIUM_MODE:
                allQuestions = QuestionListGenerator.getMediumQuestionList();
                break;
            case Question.HARD_MODE:
                allQuestions = QuestionListGenerator.getHardQuestionList();
                Collections.shuffle(allQuestions);
                break;
        }

        totalQuestions = allQuestions.size();
    }

    private void startQuiz() {
        currentQuestion = allQuestions.get(questionCount - 1);

        textViewCurrentScore.setText(Integer.toString(score));
        textViewQuestionCount.setText(questionCount + "/" + totalQuestions);
        textViewDifficulty.setText(currentQuestion.getDifficulty());
        textViewScoreAmount.setText("1");
        textViewQuestion.setText(currentQuestion.getQuestion());
        buttonOption1.setText(currentQuestion.getOption1());
        buttonOption2.setText(currentQuestion.getOption2());
        buttonOption3.setText(currentQuestion.getOption3());
        buttonOption4.setText(currentQuestion.getOption4());
    }

    private void checkAnswer() {
        answered = true;

        if (selectedAnswer == currentQuestion.getAnswerNumber()) {
            score++;
            textViewCurrentScore.setText(Integer.toString(score));
        }

        showCorrectAnswer();
    }

    private void showCorrectAnswer() {
        // Set Button text color to gray
        buttonOption1.setTextColor(grayButtonText);
        buttonOption2.setTextColor(grayButtonText);
        buttonOption3.setTextColor(grayButtonText);
        buttonOption4.setTextColor(grayButtonText);

        // Set button background to gray color
        buttonOption1.setBackgroundResource(R.drawable.button_disable_option);
        buttonOption2.setBackgroundResource(R.drawable.button_disable_option);
        buttonOption3.setBackgroundResource(R.drawable.button_disable_option);
        buttonOption4.setBackgroundResource(R.drawable.button_disable_option);

        // Display red border color
        switch (selectedAnswer) {
            case 1:
                buttonOption1.setBackgroundResource(R.drawable.button_red_border);
                break;
            case 2:
                buttonOption2.setBackgroundResource(R.drawable.button_red_border);
                break;
            case 3:
                buttonOption3.setBackgroundResource(R.drawable.button_red_border);
                break;
            case 4:
                buttonOption4.setBackgroundResource(R.drawable.button_red_border);
        }

        // Show correct answer
        switch (currentQuestion.getAnswerNumber()) {
            case 1:
                buttonOption1.setTextColor(defaultButtonTextColor);
                buttonOption1.setBackgroundResource(R.drawable.button_option_green_border);
                break;
            case 2:
                buttonOption2.setTextColor(defaultButtonTextColor);
                buttonOption2.setBackgroundResource(R.drawable.button_option_green_border);
                break;
            case 3:
                buttonOption3.setTextColor(defaultButtonTextColor);
                buttonOption3.setBackgroundResource(R.drawable.button_option_green_border);
                break;
            case 4:
                buttonOption4.setTextColor(defaultButtonTextColor);
                buttonOption4.setBackgroundResource(R.drawable.button_option_green_border);
        }

        if (questionCount < totalQuestions) {
            // Disable option buttons
            buttonOption1.setEnabled(false);
            buttonOption2.setEnabled(false);
            buttonOption3.setEnabled(false);
            buttonOption4.setEnabled(false);
            buttonConfirmAnswerNextQuestion.setText("Next Question");
        } else {
            buttonConfirmAnswerNextQuestion.setText("Finish Quiz");
        }
    }

    private void nextQuestion() {
        // Enable option buttons
        buttonOption1.setEnabled(true);
        buttonOption2.setEnabled(true);
        buttonOption3.setEnabled(true);
        buttonOption4.setEnabled(true);

        // Set text color to default color
        buttonOption1.setTextColor(defaultButtonTextColor);
        buttonOption2.setTextColor(defaultButtonTextColor);
        buttonOption3.setTextColor(defaultButtonTextColor);
        buttonOption4.setTextColor(defaultButtonTextColor);

        // Set button background to normal
        buttonOption1.setBackgroundResource(R.drawable.text_view_question_box);
        buttonOption2.setBackgroundResource(R.drawable.text_view_question_box);
        buttonOption3.setBackgroundResource(R.drawable.text_view_question_box);
        buttonOption4.setBackgroundResource(R.drawable.text_view_question_box);

        // Reset Selected answer
        selectedAnswer = 0;

        if (questionCount < totalQuestions) {
            currentQuestion = allQuestions.get(questionCount);
            answered = false;
            questionCount++;

            textViewQuestionCount.setText(questionCount + "/" + totalQuestions);
            textViewDifficulty.setText(currentQuestion.getDifficulty());
            textViewScoreAmount.setText("1");
            textViewQuestion.setText(currentQuestion.getQuestion());
            buttonOption1.setText(currentQuestion.getOption1());
            buttonOption2.setText(currentQuestion.getOption2());
            buttonOption3.setText(currentQuestion.getOption3());
            buttonOption4.setText(currentQuestion.getOption4());
            buttonConfirmAnswerNextQuestion.setText("Confirm Answer");
        } else {
           finishQuiz();
        }
    }

    private void finishQuiz() {
        Intent intent = new Intent(QuizActivity.this, ScoreActivity.class);
        intent.putExtra(EXTRA_SCORE, score);
        intent.putExtra(EXTRA_ACTIVITY, QUIZ_ACTIVITY_TAG);
        startActivity(intent);
        QuizActivity.this.finish();
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "Press back again to finish quiz", Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis();
    }

    // Handle Button click event
    @Override
    public void onClick(View v) {
        int buttonID = v.getId();

        switch (buttonID) {
            case R.id.button_option1:
                selectedAnswer = 1;
                buttonOption1.setBackgroundResource(R.drawable.button_option_green_border);
                buttonOption2.setBackgroundResource(R.drawable.text_view_question_box);
                buttonOption3.setBackgroundResource(R.drawable.text_view_question_box);
                buttonOption4.setBackgroundResource(R.drawable.text_view_question_box);
                break;
            case R.id.button_option2:
                selectedAnswer = 2;
                buttonOption1.setBackgroundResource(R.drawable.text_view_question_box);
                buttonOption2.setBackgroundResource(R.drawable.button_option_green_border);
                buttonOption3.setBackgroundResource(R.drawable.text_view_question_box);
                buttonOption4.setBackgroundResource(R.drawable.text_view_question_box);
                break;
            case R.id.button_option3:
                selectedAnswer = 3;
                buttonOption1.setBackgroundResource(R.drawable.text_view_question_box);
                buttonOption2.setBackgroundResource(R.drawable.text_view_question_box);
                buttonOption3.setBackgroundResource(R.drawable.button_option_green_border);
                buttonOption4.setBackgroundResource(R.drawable.text_view_question_box);
                break;
            case R.id.button_option4:
                selectedAnswer = 4;
                buttonOption1.setBackgroundResource(R.drawable.text_view_question_box);
                buttonOption2.setBackgroundResource(R.drawable.text_view_question_box);
                buttonOption3.setBackgroundResource(R.drawable.text_view_question_box);
                buttonOption4.setBackgroundResource(R.drawable.button_option_green_border);
                break;
            case R.id.button_confirm_answer_next_question:
                if (answered == false) {
                    if (selectedAnswer != 0) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizActivity.this, "Please select your answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    nextQuestion();
                }
        }
    }
}