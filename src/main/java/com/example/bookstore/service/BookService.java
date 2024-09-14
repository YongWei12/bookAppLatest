package com.example.bookstore.service;

import com.example.bookstore.dto.AuthorRequestDTO;
import com.example.bookstore.dto.BookRequestDTO;
import com.example.bookstore.entity.Author;
import com.example.bookstore.exception.BadRequestException;
import com.example.bookstore.exception.ResourceNotFoundException;
import com.example.bookstore.repository.AuthorRepository;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public ResponseEntity<List<Book>> findBooksByTitleAndName ( String title, String authorName ){
        List<Book> books;

        if (title != null && !title.isEmpty() && authorName != null  && !authorName.isEmpty()) {
            books = bookRepository.findByTitleAndAuthorName(title, authorName);
        } else if (title != null  && !title.isEmpty()) {
            books = bookRepository.findByTitle(title);
        } else if (authorName != null && !authorName.isEmpty() ) {
            books = bookRepository.findByAuthorName(authorName);
        } else {
            throw new BadRequestException("At least one search parameter (title or authorName) must be provided.");
        }

        if (books.isEmpty()) {
            throw new ResourceNotFoundException("No books found matching the search criteria.");
        }

        return ResponseEntity.ok(books);

    }


    public ResponseEntity<Book> updateBook(  BookRequestDTO bookDetails){

        Set<Author> authors =  bookDetails.getAuthors().stream()
                .map((authorRequestDTO) -> { return new Author(authorRequestDTO.getName(), authorRequestDTO.getBirthday());})
                .collect(Collectors.toSet());

        Book book = bookRepository.findById(bookDetails.getIsbn())
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with ISBN: " + bookDetails.getIsbn()));
        book.setTitle(bookDetails.getTitle());
        book.setYear(bookDetails.getYear());
        book.setPrice(bookDetails.getPrice());
        book.setGenre(bookDetails.getGenre());
        book.setAuthors(authors);
        return ResponseEntity.ok(bookRepository.save(book));
    }

    public ResponseEntity<Book> addBook( BookRequestDTO bookDetails) {
        if (bookRepository.existsById(bookDetails.getIsbn())) {
            throw new BadRequestException("Book with ISBN " + bookDetails.getIsbn() + " already exists.");
        }
        Set<Author> authors =  bookDetails.getAuthors().stream()
                .map((authorRequestDTO) -> { return new Author(authorRequestDTO.getName(), authorRequestDTO.getBirthday());})
                .collect(Collectors.toSet());


        // Create and save the book
        Book book = new Book(
                bookDetails.getIsbn(),
                bookDetails.getTitle(),
                bookDetails.getYear(),
                bookDetails.getPrice(),
                bookDetails.getGenre(),
                authors
        );

        Book savedBook = bookRepository.save(book);
        return ResponseEntity.status(200).body(savedBook);
    }

    public ResponseEntity<String >deleteBook(String isbn){
        if (!bookRepository.existsById(isbn)) {
            throw new ResourceNotFoundException("Book not found with ISBN: " + isbn);
        }
        bookRepository.deleteById(isbn);
        return ResponseEntity.ok("Book with ISBN " + isbn + " has been successfully deleted.");
    }



}
