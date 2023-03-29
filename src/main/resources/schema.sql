CREATE TABLE IF NOT EXISTS purchases (
    id SERIAL PRIMARY KEY,
    product varchar(50) NOT NULL,
    price NUMERIC NOT NULL
);