package org.example.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class BookStorage {
    private static Set<Book> books = new HashSet<>();

    static {
        books.add(new Book(
                UUID.randomUUID().toString(),
                "1984",
                "Оруэлл",
                320));
        books.add(new Book(
                UUID.randomUUID().toString(),
                "Война и мир",
                "Толстой",
                672));
    }

    public static Set<Book> getBooks() {
        return books;
    }


}
