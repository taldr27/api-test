-- Clients schema

-- !Ups

CREATE TABLE Clients (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- !Downs

DROP TABLE clients;
