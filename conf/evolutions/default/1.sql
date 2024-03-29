# 1.sql - Evolution script to create a clients table

# Apply evolution only if the clients table does not exist
# This prevents reapplying the evolution if it has already been applied
# You can use similar checks to handle subsequent evolutions
# For example, check if a specific column exists before adding it

# Check if the clients table exists
# If it does, do nothing; otherwise, create the table
CREATE TABLE IF NOT EXISTS clients (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);
