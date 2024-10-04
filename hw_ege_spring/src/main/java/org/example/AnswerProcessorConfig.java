package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;

@Configuration
@ComponentScan("org.example")
@Import(PropertiesConfiguration.class)
public class AnswerProcessorConfig {

    @Value("#{'${categories}'.split(',')}")
    private ArrayList<Integer> categories;

    @Bean
    public RightAnswersResolver rightAnswersResolver() {
        return new RightAnswersResolver(
                categories
        );
    }

}
