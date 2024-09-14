package com.example.bookstore.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class AuthorRequestDTO {
    @NotBlank(message = "Author name is mandatory")
    private String name;

    @NotNull(message = "Author birthday is mandatory")
    private LocalDate birthday;

    // Constructors, getters, and setters

    public AuthorRequestDTO() {}

    public AuthorRequestDTO(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    // Getters and setters...


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
