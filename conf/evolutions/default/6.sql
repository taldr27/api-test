-- Test4 schema

-- !Ups

CREATE TABLE Test4 (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- !Downs

DROP TABLE Test4;
