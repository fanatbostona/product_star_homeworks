package org.example.answer;

public class Answer {

    private int answer_number;
    private String answer_letter;

    public Answer(int an, String al) {
        answer_number = an;
        answer_letter = al;
    }

    public String getAnswer_letter() {
        return answer_letter;
    }

    @Override
    public String toString() {
        return "Question " + answer_number + ". Answer = " + answer_letter;
    }
}