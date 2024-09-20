package org.example.result;

import org.example.athlet.Distance;
import org.example.athlet.Gender;
import org.example.athlet.Person;
import org.example.athlet.Result;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;
@Service
public class ResultParser {
    private static final String sep = ",";

    public Result parseResult(String line) throws IOException {
        var resultParts = line.split(sep);
        var name = resultParts[0];
        var gender = Gender.valueOf(resultParts[1]);
        var distance = Distance.valueOf(resultParts[2]);
        var time = parseTime(resultParts[3]);

        var person = new Person(name,gender);
        return new Result(person,distance,time);
    }

    private Duration parseTime(String time) throws IOException{
        var timeParts = time.split(":");
        var totalTime = Integer.valueOf(timeParts[0]) * 60 + Integer.valueOf(timeParts[1]);
        return Duration.ofSeconds(totalTime);
    }
}
