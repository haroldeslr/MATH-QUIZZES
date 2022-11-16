package com.group2.mathquiz;

import java.util.ArrayList;
import java.util.Random;

public class QuestionGenerator {

    private static final String PLUS = " + ";
    private static final String MINUS = " - ";
    private static final String TIMES = " X ";
    private static final String DIVIDE = " / ";

    public static Question generateEasyQuestion() {
        // Left Operand Min and Max Number Range
        final int EASY_QUESTION_LEFT_OPERAND_MIN_NUMBER_RANGE = 10;
        final int EASY_QUESTION_LEFT_OPERAND_MAX_NUMBER_RANGE = 70;

        // Right Operand Min and Max Number Range
        final int EASY_QUESTION_RIGHT_OPERAND_MIN_NUMBER_RANGE = 1;
        final int EASY_QUESTION_RIGHT_OPERAND_MAX_NUMBER_RANGE = 60;

        ArrayList<String> optionList = new ArrayList<>();

        // Generate left and right operand numbers and calculate the correct answer
        int leftOperand = numberGenerator(EASY_QUESTION_LEFT_OPERAND_MIN_NUMBER_RANGE, EASY_QUESTION_LEFT_OPERAND_MAX_NUMBER_RANGE);
        int rightOperand = numberGenerator(EASY_QUESTION_RIGHT_OPERAND_MIN_NUMBER_RANGE, EASY_QUESTION_RIGHT_OPERAND_MAX_NUMBER_RANGE);
        String operator = randomOperator(1, 2);
        int correctAnswer = calculateAnswer(leftOperand, rightOperand, operator);

        // Create Question Object with Question, Option1, Option2, Option3, Option4, AnswerNumber, Difficulty Mode, Score Amount
        String question = leftOperand + operator + rightOperand;
        int answerNumber = numberGenerator(1, 4);
        String option1 = optionGenerator(Question.OPTION_1, answerNumber, correctAnswer, operator, optionList);
        optionList.add(option1);
        String option2 = optionGenerator(Question.OPTION_2, answerNumber, correctAnswer, operator, optionList);
        optionList.add(option2);
        String option3 = optionGenerator(Question.OPTION_3, answerNumber, correctAnswer, operator, optionList);
        optionList.add(option3);
        String option4 = optionGenerator(Question.OPTION_4, answerNumber, correctAnswer, operator, optionList);

        Question q = new Question(question, option1, option2, option3, option4, answerNumber, Question.EASY_MODE);
        return q;
    }

    public static Question generateMediumQuestion() {
        // Left Operand Min and Max Number Range
        final int MEDIUM_QUESTION_LEFT_OPERAND_MIN_NUMBER_RANGE = 100;
        final int MEDIUM_QUESTION_LEFT_OPERAND_MAX_NUMBER_RANGE = 140;

        // Right Operand Min and Max Number Range
        final int MEDIUM_QUESTION_RIGHT_OPERAND_MIN_NUMBER_RANGE = 5;
        final int MEDIUM_QUESTION_RIGHT_OPERAND_MAX_NUMBER_RANGE = 15;

        ArrayList<String> optionList = new ArrayList<>();

        // Generate left and right operand numbers and calculate the correct answer
        int leftOperand = numberGenerator(MEDIUM_QUESTION_LEFT_OPERAND_MIN_NUMBER_RANGE, MEDIUM_QUESTION_LEFT_OPERAND_MAX_NUMBER_RANGE);
        int rightOperand = numberGenerator(MEDIUM_QUESTION_RIGHT_OPERAND_MIN_NUMBER_RANGE, MEDIUM_QUESTION_RIGHT_OPERAND_MAX_NUMBER_RANGE);
        String operator = randomOperator(3, 4);
        int correctAnswer = calculateAnswer(leftOperand, rightOperand, operator);

        // Create Question Object with Question, Option1, Option2, Option3, Option4, AnswerNumber, Difficulty Mode, Score Amount
        String question = leftOperand + operator + rightOperand;
        int answerNumber = numberGenerator(1, 4);
        String option1 = optionGenerator(Question.OPTION_1, answerNumber, correctAnswer, operator, optionList);
        optionList.add(option1);
        String option2 = optionGenerator(Question.OPTION_2, answerNumber, correctAnswer, operator, optionList);
        optionList.add(option2);
        String option3 = optionGenerator(Question.OPTION_3, answerNumber, correctAnswer, operator, optionList);
        optionList.add(option3);
        String option4 = optionGenerator(Question.OPTION_4, answerNumber, correctAnswer, operator, optionList);

        Question q = new Question(question, option1, option2, option3, option4, answerNumber, Question.MEDIUM_MODE);
        return q;
    }

    private static int numberGenerator(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt((max - min) + 1) + min;
        return randomNumber;
    }

    private static String randomOperator(int min, int max) {
        int randomNumber = numberGenerator(min, max);
        String operator = " + ";

        switch (randomNumber) {
            case 1:
                operator = PLUS;
                break;
            case 2:
                operator = MINUS;
                break;
            case 3:
                operator = TIMES;
                break;
            case 4:
                operator = DIVIDE;
                break;
        }

        return operator;
    }

    private static int calculateAnswer(int leftNumber, int rightNumber, String operator) {
        int correctAnswer = 0;

        switch (operator) {
            case PLUS:
                correctAnswer = leftNumber + rightNumber;
                break;
            case MINUS:
                correctAnswer = leftNumber - rightNumber;
                break;
            case TIMES:
                correctAnswer = leftNumber * rightNumber;
                break;
            case DIVIDE:
                correctAnswer = leftNumber / rightNumber;
                break;
        }

        return correctAnswer;
    }

    private static String optionGenerator(int optionNumber, int answerNumber, int correctAnswer, String operator, ArrayList<String> optionList) {
        String option;
        int min = 1;
        int max = 15;

        // Check what operator
        switch (operator) {
            case PLUS:
                max = 15;
                break;
            case MINUS:
                min = -14;
                max = 14;
                break;
            case TIMES:
                max = 13;
                break;
            case DIVIDE:
                max = 8;
                break;
        }

        if (optionNumber == answerNumber) {
            option = Integer.toString(correctAnswer);
        } else {
            option = Integer.toString(numberGenerator(min, max) + correctAnswer);

            while (true) {
                if (optionList.contains(option) || Integer.parseInt(option) == correctAnswer) {
                    option = Integer.toString(Integer.parseInt(option) + numberGenerator(min, max));
                } else {
                    break;
                }
            }
        }

        return option;
    }
}
