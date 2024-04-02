-- Pets schema

-- !Ups

CREATE TABLE pets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    client_id INT NOT NULL,
    breed VARCHAR(100),
    age INT,
    date_of_birth DATE NOT NULL,
    pet_type VARCHAR(50),
    allergies TEXT NOT NULL,
    extra_information TEXT NOT NULL,
    FOREIGN KEY (client_id) REFERENCES clients(id)
);

-- Insert test data for Pets table
INSERT INTO pets (name, client_id, breed, age, date_of_birth, pet_type, allergies, extra_information)
VALUES
    ('Buddy', 1, 'Labrador Retriever', 3, '2019-05-15', 'Dog', 'None', 'Loves to play fetch.'),
    ('Mittens', 2, 'Maine Coon', 2, '2020-03-20', 'Cat', 'None', 'Enjoys lounging in the sun.'),
    ('Max', 3, 'German Shepherd', 4, '2018-09-10', 'Dog', 'Pollen', 'Needs regular exercise.'),
    ('Whiskers', 4, 'Persian', 5, '2017-12-01', 'Cat', 'None', 'Prefers quiet environments.'),
    ('Rocky', 5, 'Golden Retriever', 1, '2023-01-25', 'Dog', 'None', 'Very friendly and playful.');

-- !Downs

DROP TABLE pets;