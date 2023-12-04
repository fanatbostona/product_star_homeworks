package org.example.students;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InMemoryExamination implements Examination{

    public static final int INITIAL_CAPACITY = 256;
    private final Map <String, Score> students = new HashMap<>(INITIAL_CAPACITY);
    @Override
    public void addScore(Score score) {
        students.put(score.name(), score);
    }

    @Override
    public Score getScore(String name, String subject) throws ScoreNotFoundException {
        Score score = students.get(name);
        if (score == null)
        {
            throw new ScoreNotFoundException(name);
        }
        else
        {
            if (score.subject() == subject)
            {
                return score;
            }
            else
            {
                throw new ScoreNotFoundException(subject);
            }

        }
    }

    @Override
    public double getAverageForSubject(String subject) {
        return 0;
    }

    @Override
    public Set<String> multipleSubmissionsStudentNames() {
        return null;
    }

    @Override
    public Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject() {
        return null;
    }

    @Override
    public Collection<Score> getAllScores() {
        return null;
    }
}
