package com.manhattan.repositories;

import com.manhattan.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Set<Book> findDistinctAllByReleaseDateAfter(LocalDate date);

    Set<Book> findDistinctAllByReleaseDateBefore(LocalDate date);
}
