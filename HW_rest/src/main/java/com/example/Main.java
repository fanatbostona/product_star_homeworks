package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        // Создать
        //curl -X POST "http://localhost:8080/contacts?name=Ivan&surname=Ivanov&phoneNumber=8912&email=k@k" | json_pp

        // Получить по id
        //curl localhost:8080/contacts/1

        // Получить все
        // curl localhost:8080/contacts/

        // Обновить
        //  curl -X PUT "http://localhost:8080/contacts/1?name=Stanislav&surname=Gertel&phoneNumber=8912&email=fanatbostona@k" | json_pp


    }
}