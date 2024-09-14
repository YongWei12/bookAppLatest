-- data.sql

-- Insert AUTHOR
INSERT INTO AUTHOR ( name, birthday) VALUES ( 'J.K. Rowling', '1965-07-31');
INSERT INTO AUTHOR ( name, birthday) VALUES ( 'J.R.R. Tolkien', '1892-01-03');
INSERT INTO AUTHOR ( name, birthday) VALUES ( 'George R.R. Martin', '1948-09-20');

-- Insert BOOK
INSERT INTO BOOK (isbn, title, publication_year, price, genre) VALUES ('9780747532743', 'Harry Potter and the Philosopher''s Stone', 1997, 19.99, 'Fantasy');
INSERT INTO BOOK (isbn, title, publication_year, price, genre) VALUES ('9780261103573', 'The Lord of the Rings', 1954, 29.99, 'Fantasy');
INSERT INTO BOOK (isbn, title, publication_year, price, genre) VALUES ('9780553103540', 'A Game of Thrones', 1996, 24.99, 'Fantasy');

-- Associate BOOK with AUTHOR
INSERT INTO BOOK_AUTHOR (book_isbn, author_id) VALUES ('9780747532743', 1);
INSERT INTO BOOK_AUTHOR (book_isbn, author_id) VALUES ('9780261103573', 2);
INSERT INTO BOOK_AUTHOR (book_isbn, author_id) VALUES ('9780553103540', 3);

--inserting users
INSERT INTO USER_TABLE (username, password, role, enabled) VALUES
('user1', '$2a$10$9geUaGPZIZxk.AMgTfIc/uVec.EGDX3F8xwNfeYnpcTGZg6eqVfoq', 'ROLE_USER', true),
('admin', '$2a$10$3bCHRt2LPcd6y21N9sXiy.SAHQNST1NbbcCORLroO1vRzEwxunZDW', 'ROLE_ADMIN', true);
--password are password1, adminpass