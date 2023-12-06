package org.example.students;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryExaminationTest {

    private Examination examination;

    @BeforeEach
    void setUp()
    {
        examination = new InMemoryExamination();
    }
    @Test
    void addScore() throws ScoreNotFoundException {
        Score score = new Score("Ivanov", "Physics", 60);
        examination.addScore(score);
        Score actual = examination.getScore(score.name(), score.subject());
        Assertions.assertEquals(score,actual);
    }

    @Test
    void getScore() {
        Assertions.assertThrows(ScoreNotFoundException.class, () -> examination.getScore("Ivanov", "Physics"));
    }

    @Test
    void getAverageForSubject()
    {
        Score score = new Score("Ivanov", "Physics", 60);
        Score score1 = new Score("Sidorov", "Physics", 80);
        Score score2 = new Score("Olegov", "Maths", 40);
        Score score3 = new Score("Petrov", "Informatics", 40);
        examination.addScore(score);
        examination.addScore(score1);
        examination.addScore(score2);
        examination.addScore(score3);
        double actual = examination.getAverageForSubject("Physics");
        double expected = 70.0;
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void multipleSubmissionsStudentNames()
    {
        Score score = new Score("Ivanov", "Physics", 60);
        Score score1 = new Score("Ivanov", "Physics", 80);
        Score score2 = new Score("Olegov", "Maths", 40);
        Score score4 = new Score("Olegov", "Maths", 80);
        Score score3 = new Score("Petrov", "Informatics", 40);
        examination.addScore(score);
        examination.addScore(score1);
        examination.addScore(score2);
        examination.addScore(score3);
        examination.addScore(score4);
        Set<String> actualSurnames = examination.multipleSubmissionsStudentNames();
        Set<String> expectedSurnames = new HashSet<>();
        expectedSurnames.add("Ivanov");
        expectedSurnames.add("Olegov");
        Assertions.assertEquals(expectedSurnames,actualSurnames);
    }


    @Test
    void lastFiveStudentsWithExcellentMarkOnAnySubject()
    {
        Score score = new Score("Ivanov", "Physics", 60);
        Score score1 = new Score("Ivanov", "Physics", 80);
        Score score2 = new Score("Olegov", "Maths", 40);
        Score score4 = new Score("Olegov", "Maths", 80);
        Score score3 = new Score("Petrov", "Informatics", 40);
        Score score5 = new Score("Ustinov", "PE", 80);
        Score score6 = new Score("Ustinov", "Physics", 90);
        Score score7 = new Score("Tolstov", "Maths", 74);
        Score score8 = new Score("Shishin", "Maths", 80);
        Score score9 = new Score("Petrov", "PE", 40);
        examination.addScore(score);
        examination.addScore(score1);
        examination.addScore(score2);
        examination.addScore(score3);
        examination.addScore(score4);
        examination.addScore(score5);
        examination.addScore(score6);
        examination.addScore(score7);
        examination.addScore(score8);
        examination.addScore(score9);
        Set<String> actualSurnames = examination.lastFiveStudentsWithExcellentMarkOnAnySubject();
        Set<String> expectedSurnames = new LinkedHashSet<>();
        expectedSurnames.add(score8.name() + " " + score8.subject());
        expectedSurnames.add(score6.name() + " " + score6.subject());
        expectedSurnames.add(score5.name() + " " + score5.subject());
        expectedSurnames.add(score4.name() + " " + score4.subject());
        expectedSurnames.add(score1.name() + " " + score1.subject());
        Assertions.assertEquals(expectedSurnames,actualSurnames);
    }

    @Test
    void getAllScores()
    {
        Score score = new Score("Ivanov", "Physics", 60);
        Score score1 = new Score("Ivanov", "Physics", 80);
        Score score2 = new Score("Olegov", "Maths", 40);
        Score score4 = new Score("Olegov", "Maths", 80);
        Score score3 = new Score("Petrov", "Informatics", 40);
        Score score5 = new Score("Ustinov", "PE", 80);
        Score score6 = new Score("Ustinov", "Physics", 90);
        Score score7 = new Score("Tolstov", "Maths", 74);
        Score score8 = new Score("Shishin", "Maths", 80);
        Score score9 = new Score("Petrov", "PE", 40);
        examination.addScore(score);
        examination.addScore(score1);
        examination.addScore(score2);
        examination.addScore(score3);
        examination.addScore(score4);
        examination.addScore(score5);
        examination.addScore(score6);
        examination.addScore(score7);
        examination.addScore(score8);
        examination.addScore(score9);
        Map<String,Score> actualSurnames = examination.getAllScores();
        Map<String,Score> expectedSurnames = new HashMap<>();
        expectedSurnames.put(score.name(),score);
        expectedSurnames.put(score1.name(),score1);
        expectedSurnames.put(score2.name(),score2);
        expectedSurnames.put(score3.name(),score3);
        expectedSurnames.put(score4.name(),score4);
        expectedSurnames.put(score5.name(),score5);
        expectedSurnames.put(score6.name(),score6);
        expectedSurnames.put(score7.name(),score7);
        expectedSurnames.put(score8.name(),score8);
        expectedSurnames.put(score9.name(),score9);
        Assertions.assertEquals(expectedSurnames,actualSurnames);


    }
}