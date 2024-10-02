package org.example.answer;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AnswerParser {
    private static final String sep = " - ";

    public static Answer parseAnswer(String line) throws IOException {
        var answerLine = line.split(sep);
        var num = Integer.parseInt(answerLine[0]);
        var ans = answerLine[1];
        var newAnswer = new Answer(num,ans);

        return newAnswer;
    }
}
