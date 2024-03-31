-- Test2 schema

-- !Ups

CREATE TABLE Test2 (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- !Downs

DROP TABLE Test2;
