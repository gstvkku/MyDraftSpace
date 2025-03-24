DROP DATABASE IF EXISTS library;
CREATE DATABASE library;
\c library;


CREATE TABLE customers(
    customer_id INTEGER PRIMARY KEY,
    customer_name VARCHAR(15) NOT NULL);

CREATE TABLE books(
    book_id INTEGER PRIMARY KEY,
    book_name TEXT NOT NULL,
    book_author VARCHAR(25) NOT NULL,
    book_publisher VARCHAR(25) NOT NULL,
    book_year INTEGER,
    book_state VARCHAR(15) NOT NULL DEFAULT 'stored');

CREATE TABLE reservations(
    reservation_id INTEGER PRIMARY KEY,
    reservation_date DATE,
    customer_id INTEGER,
    book_id INTEGER,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (book_id) REFERENCES books(book_id));

INSERT INTO customers (customer_id,customer_name) VALUES (1,'Josué');
INSERT INTO customers (customer_id,customer_name) VALUES (2,'Maria');
INSERT INTO customers (customer_id,customer_name) VALUES (3,'Manel');
INSERT INTO customers (customer_id,customer_name) VALUES (4,'Walfelda');
INSERT INTO customers (customer_id,customer_name) VALUES (5,'Francelina');

INSERT INTO books (book_id,book_name,book_author,book_publisher,book_year,book_state) VALUES (1,'O Primo Basilio','Tolstoi','Dom Quixote',1973, 'on loan');
INSERT INTO books (book_id,book_name,book_author,book_publisher,book_year,book_state) VALUES (2,'Os Maias','Eça de Queirós','Porto Editora',1888, 'stored');
INSERT INTO books (book_id,book_name,book_author,book_publisher,book_year,book_state) VALUES (3,'Os Lusiadas','Luis Vaz de Camões','Bertrand',1973, 'lost');
INSERT INTO books (book_id,book_name,book_author,book_publisher,book_year,book_state) VALUES (4,'Os meus dias na livraria Morisaki','Satoshi Yagisawa','Editirial Presença',2023, 'on loan');
INSERT INTO books (book_id,book_name,book_author,book_publisher,book_year,book_state) VALUES (5,'Harry Potter and the Order of Phoenix','J.K.Rolling','Bloomsbury',2003, 'lost');

INSERT INTO reservations (reservation_id, reservation_date, customer_id,book_id) VALUES (1,'2025/01/10',4,5);
INSERT INTO reservations (reservation_id, reservation_date, customer_id,book_id) VALUES (2,'2025/01/20',1,3);
INSERT INTO reservations (reservation_id, reservation_date, customer_id,book_id) VALUES (3,'2025/01/25',3,4);
INSERT INTO reservations (reservation_id, reservation_date, customer_id,book_id) VALUES (4,'2025/02/10',4,3);

SELECT book_name FROM books WHERE book_author LIKE 'Tolstoi';

SELECT COUNT(*) FROM books WHERE book_state LIKE 'on loan';

SELECT book_publisher FROM books WHERE book_name = 'O Primo Basilio';

SELECT c.customer_name FROM customers AS c, books AS b, reservations AS r
WHERE c.customer_id = r.customer_id AND b.book_id = r.book_id AND b.book_year < 1974;
