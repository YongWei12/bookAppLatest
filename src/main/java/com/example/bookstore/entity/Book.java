package com.example.bookstore.entity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "title")
    private String title;
    @Column(name = "publication_year")
    private int year;
    @Column(name = "price")
    private double price;
    @Column(name = "genre")
    private String genre;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "BOOK_AUTHORS",
            joinColumns = @JoinColumn(name = "book_isbn"),
            inverseJoinColumns = {
                    @JoinColumn(name = "author_name", referencedColumnName = "name"),
                    @JoinColumn(name = "author_birthday", referencedColumnName = "birthday")
            }
    )
    private Set<Author> authors;

    // Constructors, Getters, and Setters

    public Book() {}

    public Book(String isbn, String title, int year, double price, String genre, Set<Author> authors) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.price = price;
        this.genre = genre;
        this.authors = authors;
    }

    // Getters and setters

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
