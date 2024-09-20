package org.example.result;

import org.example.athlet.Distance;
import org.example.athlet.Gender;
import org.example.athlet.Result;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultProcessor {
    private final Collection<Result> results;

    public ResultProcessor(Collection<Result> results) {
        this.results = results;
    }
    public List<Result> getFastest(Gender gender, Distance distance, int limit) {
        return results.stream()
                .filter(result -> result.hasDistance(distance) && result.hasGender(gender))
                .sorted(Comparator.comparing(Result::time))
                .limit(limit)
                .collect(Collectors.toList());
    }
}
