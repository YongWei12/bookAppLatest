-- Create AUTHOR Table
CREATE TABLE AUTHOR (
    name VARCHAR(255) NOT NULL,
    birthday DATE NOT NULL,
    PRIMARY KEY ( name, birthday)
);

-- Create BOOK Table
CREATE TABLE BOOK (
    isbn VARCHAR(255) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    publication_year INT,
    price DECIMAL(10, 2),
    genre VARCHAR(100)
);

-- Create Join Table for Books and Authors
CREATE TABLE BOOK_AUTHORS (
    book_isbn VARCHAR(255) NOT NULL,
    author_name VARCHAR(255) NOT NULL,
    author_birthday DATE NOT NULL,
    PRIMARY KEY (book_isbn, author_name, author_birthday),
    FOREIGN KEY (book_isbn) REFERENCES BOOK(isbn),
    FOREIGN KEY (author_name, author_birthday) REFERENCES AUTHOR(name, birthday)
);


CREATE TABLE USER_TABLE (
    username VARCHAR(50),
    password VARCHAR(500),
    role VARCHAR(50),
    enabled BOOLEAN
);
