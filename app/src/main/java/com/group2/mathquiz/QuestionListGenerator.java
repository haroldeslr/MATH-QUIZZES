package com.group2.mathquiz;

import android.util.Log;

import java.util.ArrayList;

public class QuestionListGenerator {

    public static ArrayList<Question> getEasyQuestionList() {
        final int totalEasyQuestions = 20;
        ArrayList<Question> easyQuestionList = new ArrayList<>();

        for (int i = 1; i <= totalEasyQuestions; i++) {
            easyQuestionList.add(QuestionGenerator.generateEasyQuestion());
        }

        return easyQuestionList;
    }

    public static ArrayList<Question> getMediumQuestionList() {
        final int totalMediumQuestions = 15;
        ArrayList<Question> mediumQuestionList = new ArrayList<>();

        for (int i = 1; i <= totalMediumQuestions; i++) {
            mediumQuestionList.add(QuestionGenerator.generateMediumQuestion());
        }

        return mediumQuestionList;
    }

    public static ArrayList<Question> getHardQuestionList() {
        ArrayList<Question> hardQuestionList = new ArrayList<>();

        Question question1 = new Question();
        question1.setQuestion("A large box contains 18 small boxes and each small box contains 25 chocolate bars. How many chocolate bars are in the large box?");
        question1.setOption1("450 chocolate bars");
        question1.setOption2("460 chocolate bars");
        question1.setOption3("470 chocolate bars");
        question1.setOption4("480 chocolate bars");
        question1.setAnswerNumber(Question.OPTION_1);
        question1.setDifficulty(Question.HARD_MODE);
        hardQuestionList.add(question1);

        Question question2 = new Question();
        question2.setQuestion("It takes John 25 minutes to walk to the car park and 45 to drive to work. At what time should he get out of the house in order to get to work at 9:00 a.m.?");
        question2.setOption1("7:40 a.m.");
        question2.setOption2("7:50 a.m.");
        question2.setOption3("7:55 a.m.");
        question2.setOption4("7:30 a.m.");
        question2.setAnswerNumber(Question.OPTION_2);
        question2.setDifficulty(Question.HARD_MODE);
        hardQuestionList.add(question2);

        Question question3 = new Question();
        question3.setQuestion("Kim can walk 4 kilometers in one hour. How long does it take Kim to walk 18 kilometers?");
        question3.setOption1("4 hours and 13 minutes");
        question3.setOption2("4 hours and 22 minutes");
        question3.setOption3("4 hours and 30 minutes");
        question3.setOption4("4 hours and 19 minutes");
        question3.setAnswerNumber(Question.OPTION_3);
        question3.setDifficulty(Question.HARD_MODE);
        hardQuestionList.add(question3);

        Question question4 = new Question();
        question4.setQuestion("A factory produced 2300 TV sets in its first year of production. 4500 sets were produced in its second year and 500 more sets were produced in its third year than in its second year. How many TV sets were produced in three years?");
        question4.setOption1("11,510 TV sets");
        question4.setOption2("11,340 TV sets");
        question4.setOption3("11,750 TV sets");
        question4.setOption4("11,800 TV sets");
        question4.setAnswerNumber(Question.OPTION_4);
        question4.setDifficulty(Question.HARD_MODE);
        hardQuestionList.add(question4);

        Question question5 = new Question();
        question5.setQuestion("Linda bought 3 notebooks at $1.20 each; a box of pencils at $1.50 and a box of pens at $1.70. How much did Linda spend?");
        question5.setOption1("$6.80");
        question5.setOption2("$6.40");
        question5.setOption3("$6.55");
        question5.setOption4("$6.34");
        question5.setAnswerNumber(Question.OPTION_1);
        question5.setDifficulty(Question.HARD_MODE);
        hardQuestionList.add(question5);

        Question question6 = new Question();
        question6.setQuestion("Tom and Bob have a total of 49 toys. If Bob has 5 more toys than Tom, how many toys does each one have?");
        question6.setOption1("Tom: 21 , Bob: 37");
        question6.setOption2("Tom: 22 , Bob: 27");
        question6.setOption3("Tom: 32 , Bob: 17");
        question6.setOption4("Tom: 19 , Bob: 25");
        question6.setAnswerNumber(Question.OPTION_2);
        question6.setDifficulty(Question.HARD_MODE);
        hardQuestionList.add(question6);

        Question question7 = new Question();
        question7.setQuestion("John can eat a quarter of a pizza in one minute. How long does it take John to eat one pizza and a half?");
        question7.setOption1("8 minutes");
        question7.setOption2("5 minutes");
        question7.setOption3("4 minutes");
        question7.setOption4("7 minutes");
        question7.setAnswerNumber(Question.OPTION_3);
        question7.setDifficulty(Question.HARD_MODE);
        hardQuestionList.add(question7);

        Question question8 = new Question();
        question8.setQuestion("John can eat a sixth of a pizza in two minutes. It takes 3 minutes for Billy to eat one quarter of the same pizza. If John and Billy start eating one pizza each, who will finish first?");
        question8.setOption1("same time , 10 minutes");
        question8.setOption2("same time , 13 minutes");
        question8.setOption3("same time , 16 minutes");
        question8.setOption4("same time , 12 minutes");
        question8.setAnswerNumber(Question.OPTION_4);
        question8.setDifficulty(Question.HARD_MODE);
        hardQuestionList.add(question8);

        Question question9 = new Question();
        question9.setQuestion("John read the quarter of the time that Tom read. Tom read only two-fifth of the time that Sasha read. Sasha read twice as long as Mike. If Mike read 5 hours, how long did John read?");
        question9.setOption1("1 hour");
        question9.setOption2("4 hour");
        question9.setOption3("3 hour");
        question9.setOption4("5 hour");
        question9.setAnswerNumber(Question.OPTION_1);
        question9.setDifficulty(Question.HARD_MODE);
        hardQuestionList.add(question9);

        Question question10 = new Question();
        question10.setQuestion("Jim, Carla and Tomy are members of the same family. Carla is 5 years older than Jim. Tomy is 6 years older than Carla. The sum of their three ages is 31 years. How old is each one them?");
        question10.setOption1("Jim: 6 years , Carla: 11 years , Tomy: 17 years");
        question10.setOption2("Jim: 5 years , Carla: 10 years , Tomy: 16 years");
        question10.setOption3("Jim: 4 years , Carla: 9 years , Tomy: 15 years");
        question10.setOption4("Jim: 8 years , Carla: 13 years , Tomy: 19 years");
        question10.setAnswerNumber(Question.OPTION_2);
        question10.setDifficulty(Question.HARD_MODE);
        hardQuestionList.add(question10);

        Question question11 = new Question();
        question11.setQuestion("Mel had $35 and withdraw some more money from his bank account. He bought a pair of trousers at $34.00, two shirts at $16.00 each and 2 pairs of shoes at $24.00 each. After the shopping, he had $32.00 left. How much money did Mel withdraw from the bank?");
        question11.setOption1("$114");
        question11.setOption2("$119");
        question11.setOption3("$111");
        question11.setOption4("$121");
        question11.setAnswerNumber(Question.OPTION_3);
        question11.setDifficulty(Question.HARD_MODE);
        hardQuestionList.add(question11);

        Question question12 = new Question();
        question12.setQuestion("How many minutes are in one week?");
        question12.setOption1("10,090 minutes");
        question12.setOption2("10,060 minutes");
        question12.setOption3("10,040 minutes");
        question12.setOption4("10,020 minutes");
        question12.setAnswerNumber(Question.OPTION_4);
        question12.setDifficulty(Question.HARD_MODE);
        hardQuestionList.add(question12);

        Question question13 = new Question();
        question13.setQuestion("In Tim's house, a rectangular swimming pool (blue) whose length 30 meters and width 10 meters is surounded by grass (green). The pool with the grassy area make a large rectangle whose length is 50 meters and width 20 meters. What area is occupied by the grass?");
        question13.setOption1("700 meters squared");
        question13.setOption2("570 meters squared");
        question13.setOption3("320 meters squared");
        question13.setOption4("900 meters squared");
        question13.setAnswerNumber(Question.OPTION_1);
        question13.setDifficulty(Question.HARD_MODE);
        hardQuestionList.add(question13);

        Question question14 = new Question();
        question14.setQuestion("Mary wants to make a box. She starts with a piece of cardboard whose length is 15 centimeters and with is 10 centimeters. Then she cuts congruent squares with side of 3 centimeters at the four corners. What is the area of the cardboard after she cuts the 4 corners?");
        question14.setOption1("116 centimeters squared");
        question14.setOption2("114 centimeters squared");
        question14.setOption3("130 centimeters squared");
        question14.setOption4("111 centimeters squared");
        question14.setAnswerNumber(Question.OPTION_2);
        question14.setDifficulty(Question.HARD_MODE);
        hardQuestionList.add(question14);

        Question question15 = new Question();
        question15.setQuestion("A painter charges $ 225 for materials and $ 35 per hour for labour. The total cost of painting an office is $ 330. How many hours did it take the painter to paint the office?");
        question15.setOption1("7 hours");
        question15.setOption2("5 hours");
        question15.setOption3("3 hours");
        question15.setOption4("1 hour");
        question15.setAnswerNumber(Question.OPTION_3);
        question15.setDifficulty(Question.HARD_MODE);
        hardQuestionList.add(question15);

        return hardQuestionList;
    }
}
