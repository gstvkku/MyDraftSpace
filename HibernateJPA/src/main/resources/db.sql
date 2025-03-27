DROP DATABASE IF EXISTS myHotel;
CREATE DATABASE myHotel;
\c javabank;

DROP TABLE IF EXISTS customers;

-- Schema Creation
CREATE TABLE customers
(
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(255),
    street  VARCHAR(255),
    city    VARCHAR(255),
    zipcode VARCHAR(255)

);

