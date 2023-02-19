CREATE TABLE IF NOT EXISTS clothe(
    id IDENTITY,
    name VARCHAR(40) NOT NULL,
    price DOUBLE NOT NULL,
    year_of_creation VARCHAR(4) NOT NULL,
    brand VARCHAR(20) NOT NULL
);