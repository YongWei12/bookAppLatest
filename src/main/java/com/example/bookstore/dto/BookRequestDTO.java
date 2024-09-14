package com.example.bookstore.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

public class BookRequestDTO {
    @NotBlank(message = "ISBN is mandatory")
    private String isbn;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @Min(value = 0, message = "Year must be positive")
    private int year;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    private double price;

    @NotBlank(message = "Genre is mandatory")
    private String genre;

    @NotEmpty(message = "At least one author is required")
    private Set<AuthorRequestDTO> authors;

    // Constructors, getters, and setters...

    public BookRequestDTO() {}

    public BookRequestDTO(String isbn, String title, int year, double price, String genre, Set<AuthorRequestDTO> authors) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.price = price;
        this.genre = genre;
        this.authors = authors;
    }

    // Getters and setters...

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

    public Set<AuthorRequestDTO> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorRequestDTO> authors) {
        this.authors = authors;
    }
}
