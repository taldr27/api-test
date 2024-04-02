-- Veterinaries schema

-- !Ups

CREATE TABLE veterinaries (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL,
    phone_number VARCHAR(20),
    email VARCHAR(255),
    website VARCHAR(255)
);

-- Seed data for veterinaries table
INSERT INTO veterinaries (name, address, city, state, country, phone_number, email, website) VALUES
('Happy Pets Veterinary Clinic', '123 Main St', 'Anytown', 'CA', 'USA', '123-456-7890', 'info@happypetsvetclinic.com', 'http://www.happypetsvetclinic.com'),
('Paws & Claws Animal Hospital', '456 Oak St', 'Smallville', 'NY', 'USA', '555-123-4567', 'info@pawsandclaws.com', 'http://www.pawsandclaws.com'),
('Pet Care Veterinary Center', '789 Elm St', 'Metroville', 'TX', 'USA', '888-555-1234', 'info@petcarevetcenter.com', 'http://www.petcarevetcenter.com'),
('Animal Wellness Center', '321 Pine St', 'Countryside', 'FL', 'USA', '999-888-7777', 'info@animalwellnesscenter.com', 'http://www.animalwellnesscenter.com'),
('Family Pet Hospital', '567 Maple St', 'Sunnydale', 'CA', 'USA', '777-999-8888', 'info@familypethospital.com', 'http://www.familypethospital.com');


-- !Downs

DROP TABLE veterinaries;
