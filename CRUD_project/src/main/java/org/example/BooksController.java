package org.example;

import org.example.model.Book;
import org.example.model.BookStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class BooksController {

    @GetMapping("/")
    public String bookList(Model model) {
        model.addAttribute("books", BookStorage.getBooks());
        return "books-list";
    }

    @GetMapping("/create-form")
    public String createForm() {
        return "create-form";
    }

    @PostMapping("/create")
    public String create(Book book) {
        book.setId(UUID.randomUUID().toString());
        BookStorage.getBooks().add(book);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        Book bookToDelete = BookStorage.getBooks().stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
        BookStorage.getBooks().remove(bookToDelete);
        return "redirect:/";
    }

    @GetMapping("/edit-form/{id}")
    public String update(@PathVariable("id") String id, Model model) {
        Book bookToEdit = BookStorage.getBooks().stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
        model.addAttribute("book", bookToEdit);
        return "edit-form";
    }

    @PostMapping("/update")
    public String update(Book book){
        delete(book.getId());
        BookStorage.getBooks().add(book);
        return "redirect:/";
    }

}
