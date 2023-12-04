package org.example.students;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryExaminationTest {

    private Examination examination;

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
    void getAverageForSubject() {
    }

    @Test
    void multipleSubmissionsStudentNames() {
    }

    @Test
    void lastFiveStudentsWithExcellentMarkOnAnySubject() {
    }

    @Test
    void getAllScores() {
    }
}