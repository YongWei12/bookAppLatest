package com.example.bookstore.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@IdClass(AuthorId.class)
@Table(name = "AUTHOR")
public class Author {
    @Id
    private String name;

    @Id
    private LocalDate birthday;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    // Constructors, getters, and setters...

    public Author() {}

    public Author(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
