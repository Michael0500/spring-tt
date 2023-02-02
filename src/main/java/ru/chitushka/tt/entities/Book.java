package ru.chitushka.tt.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "book_tbl")
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
    @Column(name = "year")
    private int year_publish;


    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year_publish = year;
    }
}
