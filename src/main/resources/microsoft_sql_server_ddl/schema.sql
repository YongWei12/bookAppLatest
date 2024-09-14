-- schema.sql

-- Drop existing tables if they exist
IF OBJECT_ID('dbo.book_authors', 'U') IS NOT NULL
    DROP TABLE dbo.book_authors;


IF OBJECT_ID('dbo.author', 'U') IS NOT NULL
    DROP TABLE dbo.author;


IF OBJECT_ID('dbo.book', 'U') IS NOT NULL
    DROP TABLE dbo.book;


IF OBJECT_ID('dbo.user_table', 'U') IS NOT NULL
    DROP TABLE dbo.user_table;



CREATE TABLE dbo.author (
    name NVARCHAR(255) NOT NULL,
    birthday DATE NOT NULL,
    CONSTRAINT PK_author PRIMARY KEY (name, birthday)
);


CREATE TABLE dbo.book (
    isbn NVARCHAR(255) NOT NULL,
    title NVARCHAR(255) NOT NULL,
    publication_year INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    genre NVARCHAR(100) NOT NULL,
    CONSTRAINT PK_book PRIMARY KEY (isbn)
);



CREATE TABLE dbo.book_authors (
    book_isbn NVARCHAR(255) NOT NULL,
    author_name NVARCHAR(255) NOT NULL,
    author_birthday DATE NOT NULL,
    CONSTRAINT PK_book_authors PRIMARY KEY (book_isbn, author_name, author_birthday),
    CONSTRAINT FK_book_authors_book FOREIGN KEY (book_isbn) REFERENCES dbo.book(isbn),
    CONSTRAINT FK_book_authors_author FOREIGN KEY (author_name, author_birthday) REFERENCES dbo.author(name, birthday)
);



CREATE TABLE user_table (
    username NVARCHAR(50),
    password NVARCHAR(500),
    role NVARCHAR(50),
    enabled BIT
);

