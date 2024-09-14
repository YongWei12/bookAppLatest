-- data.sql

-- Insert AUTHOR
INSERT INTO AUTHOR ( name, birthday) VALUES ( 'JK Rowling', '1950-07-31');
INSERT INTO AUTHOR ( name, birthday) VALUES ( 'JR Tolkien', '1950-01-03');
INSERT INTO AUTHOR ( name, birthday) VALUES ( 'George RR Martin', '1950-09-20');

-- Insert BOOK
INSERT INTO BOOK (isbn, title, publication_year, price, genre) VALUES ('9780747532743', 'Harry Potter and the Philosophers Stone', 2000, 19.99, 'Fantasy');
INSERT INTO BOOK (isbn, title, publication_year, price, genre) VALUES ('9780261103573', 'The Lord of the Rings', 2000, 29.99, 'Fantasy');
INSERT INTO BOOK (isbn, title, publication_year, price, genre) VALUES ('9780553103540', 'A Game of Thrones', 2000, 24.99, 'Fantasy');

-- Associate Books with Authors using Composite Keys
INSERT INTO book_authors (book_isbn, author_name, author_birthday) VALUES ('9780747532743',  'JK Rowling', '1950-07-31');
INSERT INTO book_authors (book_isbn, author_name, author_birthday) VALUES ('9780261103573', 'JR Tolkien', '1950-01-03');
INSERT INTO book_authors (book_isbn, author_name, author_birthday) VALUES ('9780553103540', 'George RR Martin', '1950-09-20');

--inserting users
INSERT INTO USER_TABLE (username, password, role, enabled) VALUES
('user1', '$2a$10$9geUaGPZIZxk.AMgTfIc/uVec.EGDX3F8xwNfeYnpcTGZg6eqVfoq', 'ROLE_USER', 1),
('admin', '$2a$10$3bCHRt2LPcd6y21N9sXiy.SAHQNST1NbbcCORLroO1vRzEwxunZDW', 'ROLE_ADMIN', 1);
--password are password1, adminpass