package com.example.bookstore.controller;
import com.example.bookstore.dto.BookRequestDTO;
import com.example.bookstore.entity.Book;
import com.example.bookstore.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BbookstoreController {
    @Autowired
    BookService bookService;

    @GetMapping("/findAllBooks")
    public List<Book> findAllBooks() {
        return bookService.findAllBooks(); // Replace with actual search logic
    }

    // Find books by title and/or author (Exact Match)
    @GetMapping("/findBooksByTitleAndName")
    public ResponseEntity<List<Book>> findBooksByTitleAndName(@RequestParam(required = false) String title,
                                                @RequestParam(required = false) String authorName) {
        return bookService.findBooksByTitleAndName(title, authorName);
    }


    // Update a book
    @PutMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@Valid @RequestBody BookRequestDTO bookDetails) {
        return bookService.updateBook( bookDetails);
    }

    // Add a new book
    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@Valid @RequestBody BookRequestDTO bookDetails) {
        return bookService.addBook(bookDetails);
    }

    // Delete a book (Restricted to ADMIN role)
    @PreAuthorize("ADMIN")
    @DeleteMapping("/deleteBook")
    public ResponseEntity<String> deleteBook(@RequestParam String isbn) {
        return bookService.deleteBook(isbn);
    }



}
