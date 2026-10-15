
package com.practica.biblioteca.service;

import com.practica.biblioteca.dto.BookDTO;
import com.practica.biblioteca.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    // Lista para almacenar libros en memoria
    private final List<Book> books = new ArrayList<>();

    // Contador para generar IDs
    private Long nextId = 1L;

    // CREATE - Registrar un libro
    public Book createBook(BookDTO dto) {

        Book book = new Book(
                nextId++,
                dto.getTitle(),
                dto.getAuthor(),
                dto.getIsbn(),
                dto.getPublicationYear(),
                dto.getCategory(),
                dto.getAvailable()
        );

        books.add(book);
        return book;
    }

    // READ - Obtener todos los libros
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    // READ - Buscar un libro por ID
    public Optional<Book> getBookById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    // UPDATE - Actualizar un libro
    public Optional<Book> updateBook(Long id, BookDTO dto) {

        Optional<Book> existingBook = getBookById(id);

        if (existingBook.isPresent()) {

            Book book = existingBook.get();

            book.setTitle(dto.getTitle());
            book.setAuthor(dto.getAuthor());
            book.setIsbn(dto.getIsbn());
            book.setPublicationYear(dto.getPublicationYear());
            book.setCategory(dto.getCategory());
            book.setAvailable(dto.getAvailable());

            return Optional.of(book);
        }

        return Optional.empty();
    }

    // DELETE - Eliminar un libro
    public boolean deleteBook(Long id) {
        return books.removeIf(
                book -> book.getId().equals(id)
        );
    }
}
