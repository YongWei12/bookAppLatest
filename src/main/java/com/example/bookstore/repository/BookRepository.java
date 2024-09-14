package com.example.bookstore.repository;

import com.example.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    // Find books by title
    List<Book> findByTitle(String title);

    // Find books by author name
    @Query("SELECT b FROM Book b JOIN b.authors a WHERE a.name = :authorName")
    List<Book> findByAuthorName(String authorName);

    // Find books by title and author name
    @Query("SELECT b FROM Book b JOIN b.authors a WHERE b.title = :title AND a.name = :authorName")
    List<Book> findByTitleAndAuthorName(String title, String authorName);

}

