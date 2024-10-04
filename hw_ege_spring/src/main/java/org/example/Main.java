package org.example;

import org.example.answer.Answer;
import org.example.answer.AnswerProcessor;
import org.example.answer.AnswerReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        var applicationContext = new AnnotationConfigApplicationContext(AnswerProcessorConfig.class);
        var resultsReader = applicationContext.getBean(AnswerReader.class);

        var rightAnswersFile = Paths.get("textFiles/right.txt");
        var pupilAnswersFile = Paths.get("textFiles/pupil.txt");
        var rightAnswers = resultsReader.readFromFile(rightAnswersFile);
        var pupilAnswers = resultsReader.readFromFile(pupilAnswersFile);

        for (Answer c : rightAnswers)
            System.out.println(c);

        System.out.println("---------------------");

        for (Answer c : pupilAnswers)
            System.out.println(c);


        var rightsAnswersResolver = applicationContext.getBean(RightAnswersResolver.class);

        System.out.println("Сумма баллов = " + rightsAnswersResolver.resultSum(rightAnswers,pupilAnswers));



    }
}