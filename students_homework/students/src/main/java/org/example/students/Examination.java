package org.example.students;

import java.util.Map;
import java.util.Set;

public interface Examination {
    void addScore(Score score);

    Score getScore(String name, String subject) throws ScoreNotFoundException;

    double getAverageForSubject(String subject);

    Set<String> multipleSubmissionsStudentNames();

    Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject();

    Map<String, Score> getAllScores();
}
