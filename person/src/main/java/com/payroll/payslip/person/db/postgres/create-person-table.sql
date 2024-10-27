CREATE TABLE IF NOT EXISTS public.persons
(
    id BIGINT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    second_name VARCHAR(255),
    surname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    date_birth DATE,
    is_delete BOOLEAN
    );