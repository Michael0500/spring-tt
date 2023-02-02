package ru.chitushka.tt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.chitushka.tt.entities.Book;
import ru.chitushka.tt.repositories.BookRepository;

@SpringBootApplication
public class TtApplication {

    public static void main(String[] args) {
        SpringApplication.run(TtApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(BookRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Book("Достоевский", "Преступление и наказание", 2001));
            repository.save(new Book("Толстой", "Война и мир", 2016));
            repository.save(new Book("Пушкин", "Сказка о Царе Салтане", 1999));
        };
    }
}
