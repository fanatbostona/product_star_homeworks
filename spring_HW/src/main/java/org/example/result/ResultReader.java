package org.example.result;

import org.example.athlet.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultReader {
    private final ResultParser resultParser;

    @Autowired
    public ResultReader(ResultParser resultParser) throws IOException{
        this.resultParser = resultParser;
    }
    public List<Result> readFromFileЫ(Path filePath) throws IOException{
        try {
            return Files.lines(filePath)
                    .map(resultParser::parseResult)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
