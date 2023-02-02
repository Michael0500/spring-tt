package ru.chitushka.tt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.chitushka.tt.entities.Book;
import ru.chitushka.tt.repositories.BookRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    BookRepository repository;

    @Autowired
    public HomeController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String index(Model model) {
        List<Book> books = repository.findAll();

        model.addAttribute("books", books);
        model.addAttribute("today",
                (new SimpleDateFormat("dd MMMM yyyy")).format(Calendar.getInstance().getTime()));


        return "index";
    }

}
