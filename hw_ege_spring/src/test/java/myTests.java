import org.example.AnswerProcessorConfig;
import org.example.RightAnswersResolver;
import org.example.answer.AnswerReader;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class myTests {

    @Test
    public void testSummary() throws IOException {
        var applicationContext = new AnnotationConfigApplicationContext(AnswerProcessorConfig.class);
        var resultsReader = applicationContext.getBean(AnswerReader.class);
        var rightAnswersFile = Paths.get("textFiles/right.txt");
        var pupilAnswersFile = Paths.get("textFiles/pupil.txt");
        var rightAnswers = resultsReader.readFromFile(rightAnswersFile);
        var pupilAnswers = resultsReader.readFromFile(pupilAnswersFile);
        var rightsAnswersResolver = applicationContext.getBean(RightAnswersResolver.class);
        int result = rightsAnswersResolver.resultSum(rightAnswers,pupilAnswers);

        assertEquals(18,result);
    }

    @Test
    public void testSummary1()  throws IOException {
        var applicationContext = new AnnotationConfigApplicationContext(AnswerProcessorConfig.class);
        var resultsReader = applicationContext.getBean(AnswerReader.class);
        var rightAnswersFile = Paths.get("textFiles/right1.txt");
        var pupilAnswersFile = Paths.get("textFiles/pupil1.txt");
        var rightAnswers = resultsReader.readFromFile(rightAnswersFile);
        var pupilAnswers = resultsReader.readFromFile(pupilAnswersFile);
        var rightsAnswersResolver = applicationContext.getBean(RightAnswersResolver.class);
        int result = rightsAnswersResolver.resultSum(rightAnswers,pupilAnswers);

        assertEquals(0,result);
    }

    @Test
    public void testSummary2()  throws IOException {
        var applicationContext = new AnnotationConfigApplicationContext(AnswerProcessorConfig.class);
        var resultsReader = applicationContext.getBean(AnswerReader.class);
        var rightAnswersFile = Paths.get("textFiles/right2.txt");
        var pupilAnswersFile = Paths.get("textFiles/pupil2.txt");
        var rightAnswers = resultsReader.readFromFile(rightAnswersFile);
        var pupilAnswers = resultsReader.readFromFile(pupilAnswersFile);
        var rightsAnswersResolver = applicationContext.getBean(RightAnswersResolver.class);
        int result = rightsAnswersResolver.resultSum(rightAnswers,pupilAnswers);

        assertEquals(6,result);
    }


}
