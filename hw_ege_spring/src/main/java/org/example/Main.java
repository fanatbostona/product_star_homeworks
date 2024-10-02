package org.example;

import org.example.answer.AnswerProcessor;
import org.example.answer.AnswerReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        var applicationContext = new AnnotationConfigApplicationContext(AnswerProcessorConfig.class);
        var resultsReader = applicationContext.getBean(AnswerReader.class);

        var rightAnswersFile = new ClassPathResource("org/example/right.txt").getFile().toPath();
        var pupilAnswersFile = new ClassPathResource("org/example/pupil.txt").getFile().toPath();
        var rightAnswers = resultsReader.readFromFile(rightAnswersFile);
        var pupilAnswers = resultsReader.readFromFile(pupilAnswersFile);

        var rightAnswersProcessor = new AnswerProcessor(rightAnswers);
        var pupilAnswersProcessor = new AnswerProcessor(pupilAnswers);

        System.out.println(rightAnswersProcessor);
        System.out.println();
        System.out.println(pupilAnswersProcessor);
    }
}