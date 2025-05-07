package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ContactReader {

    private Long ID = 5L;
    public List<Contact> readFromFile(Path filePath) {
        List<Contact> contacts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(String.valueOf(filePath)))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String[] name = data[0].split(" ");
                ID++;
                contacts.add(new Contact(ID, name[0], name[1], data[1], data[2]));
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }

        return contacts;
    }
}
