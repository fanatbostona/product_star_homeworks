package org.example.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AnswerReader {

    private final AnswerParser answerParser;

    @Autowired
    public AnswerReader(AnswerParser ap) throws IOException {
        this.answerParser = ap;
    }

    public static List<Answer> readFromFile (Path filePath) throws IOException {
        List<Answer> answers = new ArrayList<>();
        try(Stream<String> lines = Files.lines(filePath)){
             answers = lines
                    .map(line -> {
                        try {
                            return AnswerParser.parseAnswer(line);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .collect(Collectors.toList());
        }
        return answers;
    }

}
