-- Create AUTHOR Table
CREATE TABLE AUTHOR (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birthday DATE
);

-- Create BOOK Table
CREATE TABLE BOOK (
    isbn VARCHAR(13) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    publication_year INT,
    price DECIMAL(10, 2),
    genre VARCHAR(100)
);

-- Create Book_AUTHOR Join Table
CREATE TABLE BOOK_AUTHOR (
    book_isbn VARCHAR(13),
    author_id BIGINT,
    PRIMARY KEY (book_isbn, author_id),
    FOREIGN KEY (book_isbn) REFERENCES BOOK(isbn) ON DELETE CASCADE,
    FOREIGN KEY (author_id) REFERENCES AUTHOR(id) ON DELETE CASCADE
);


CREATE TABLE USER_TABLE (
    username VARCHAR(50),
    password VARCHAR(500),
    role VARCHAR(50),
    enabled BOOLEAN
);
