package com.practica.biblioteca.repository;

import com.practica.biblioteca.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Spring Data JPA provee automáticamente métodos como findAll(), save(), findById(), deleteById()
}