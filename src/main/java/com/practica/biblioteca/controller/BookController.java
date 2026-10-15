
package com.practica.biblioteca.controller;

import com.practica.biblioteca.dto.BookDTO;
import com.practica.biblioteca.model.Book;
import com.practica.biblioteca.service.BookService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    // Constructor para inyectar el Service
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // POST - Registrar un libro
    @PostMapping
    public ResponseEntity<Book> createBook(
            @Valid @RequestBody BookDTO dto) {

        Book book = bookService.createBook(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(book);
    }

    // GET - Obtener todos los libros
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {

        return ResponseEntity.ok(
                bookService.getAllBooks()
        );
    }

    // GET - Buscar un libro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(
            @PathVariable Long id) {

        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() ->
                        ResponseEntity.notFound().build()
                );
    }

    // PUT - Actualizar un libro
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(
            @PathVariable Long id,
            @Valid @RequestBody BookDTO dto) {

        return bookService.updateBook(id, dto)
                .map(ResponseEntity::ok)
                .orElseGet(() ->
                        ResponseEntity.notFound().build()
                );
    }

    // DELETE - Eliminar un libro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(
            @PathVariable Long id) {

        boolean deleted = bookService.deleteBook(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
