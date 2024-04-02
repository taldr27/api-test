-- Clients schema

-- !Ups

CREATE TABLE Clients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    address VARCHAR(255),
    email VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    number_of_visits INT,
    unique_id VARCHAR(10) NOT NULL
);

-- Inserting test data
INSERT INTO clients (name, lastname, phone_number, address, email, created_at, number_of_visits, unique_id) VALUES
('John', 'Doe', '123456789', '123 Main St', 'john@example.com', NOW(), 3, 'JD001'),
('Jane', 'Smith', '987654321', '456 Oak St', 'jane@example.com', NOW(), 5, 'JS001'),
('Alice', 'Johnson', '555123456', '789 Elm St', 'alice@example.com', NOW(), 2, 'AJ001'),
('Bob', 'Brown', '999888777', NULL, 'bob@example.com', NOW(), 1, 'BB001'),
('Emma', 'Garcia', '111222333', '321 Pine St', 'emma@example.com', NOW(), NULL, 'EG001');

-- !Downs

DROP TABLE clients;
