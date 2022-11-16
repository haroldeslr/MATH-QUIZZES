package com.group2.mathquiz;

public class Question {

    public static final String EASY_MODE = "Easy Mode";
    public static final String MEDIUM_MODE = "Medium Mode";
    public static final String HARD_MODE = "Hard Mode";

    public static final int OPTION_1 = 1;
    public static final int OPTION_2 = 2;
    public static final int OPTION_3 = 3;
    public static final int OPTION_4 = 4;

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int answerNumber;
    private String difficulty;

    public Question() {}

    public Question(String question, String option1, String option2, String option3, String option4, int answerNumber, String difficulty) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answerNumber = answerNumber;
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public int getAnswerNumber() {
        return answerNumber;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public void setAnswerNumber(int answerNumber) {
        this.answerNumber = answerNumber;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
