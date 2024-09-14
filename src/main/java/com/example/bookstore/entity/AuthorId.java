package com.example.bookstore.entity;


import java.io.Serializable;
import java.time.LocalDate;

public class AuthorId implements Serializable {

    private String name;
    private LocalDate birthday;

    public AuthorId() {}

    public AuthorId(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    // Getters, setters, equals(), and hashCode()

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorId authorId = (AuthorId) o;

        if (!name.equals(authorId.name)) return false;
        return birthday.equals(authorId.birthday);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + birthday.hashCode();
        return result;
    }
}