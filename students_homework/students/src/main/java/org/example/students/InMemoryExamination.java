package org.example.students;

import java.util.*;

public class InMemoryExamination implements Examination{

    public static final int INITIAL_CAPACITY = 256;
    private Map <String, Score> students = new HashMap<>(INITIAL_CAPACITY);
    private List<Score> allScores = new ArrayList<>();
    @Override
    public void addScore(Score score) {
        students.put(score.name(), score);
        allScores.add(score);
    }

    @Override
    public Score getScore(String name, String subject) throws ScoreNotFoundException {
        Score score = students.get(name);
        if (score == null || score.subject() != subject)
        {
            throw new ScoreNotFoundException(name);
        }
        else
        {
            return score;
        }
    }

    @Override
    public double getAverageForSubject(String subject) {
        int sum = 0;
        int kol = 0;
        for (Score score : students.values())
        {
            if (score.subject() == subject)
            {
                sum += score.score();
                kol += 1;
            }

        }
        return sum/kol;
    }

    @Override
    public Set<String> multipleSubmissionsStudentNames()
    {
        Map<String, ArrayList<Score>> all_marks = new HashMap<>();
        for (Score s: allScores)
        {
            String nameSubject = s.name()+s.subject();
            ArrayList<Score> scores = new ArrayList<>();
            if (all_marks.containsKey(nameSubject))
            {
                scores = all_marks.get(nameSubject);
                scores.add(s);
                all_marks.put(nameSubject,scores);
            }
            else
            {
                scores.add(s);
                all_marks.put(nameSubject,scores);
            }
        }
        Set<String> studentsSurnames = new HashSet<>();
        for (String key: all_marks.keySet()) {
            ArrayList<Score> scores = all_marks.get(key);
            if (scores.size() > 1)
            {
                for (Score s: scores)
                {
                    studentsSurnames.add(s.name());
                }
            }
        }

        return studentsSurnames;
    }

    @Override
    public Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject()
    {
        Set<String> lastFiveStudents = new LinkedHashSet<>();
        Collections.reverse(allScores);
        int kolFive = 0;
        for (Score s : allScores)
        {
            if (s.score() >= 75 && kolFive != 5)
            {
                lastFiveStudents.add(s.name() + " " + s.subject());
                kolFive++;
            }
        }
        return lastFiveStudents;
    }

    @Override
    public Map<String, Score> getAllScores() {
        return new HashMap<>(students);
    }


}
