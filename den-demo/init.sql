CREATE DATABASE Dendb;

CREATE TABLE IF NOT EXISTS users (
                                     id SERIAL PRIMARY KEY,
                                     name VARCHAR(100) NOT NULL,
                                     surname VARCHAR(100) NOT NULL,
                                     email VARCHAR(255) NOT NULL UNIQUE,
                                     age INT
);

-- Вставка данных в таблицу users
INSERT INTO users (name, surname, email, age) VALUES
                                                    ('Jan', 'Kowalski', 'jan.kowalski@example.com', 30),
                                                    ('Anna', 'Nowak', 'anna.nowak@example.com', 25),
                                                    ('Piotr', 'Zieliński', 'piotr.zielinski@example.com', 35);