package ru.chitushka.tt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.chitushka.tt.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
