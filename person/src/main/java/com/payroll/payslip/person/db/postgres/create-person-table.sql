CREATE TABLE IF NOT EXISTS public.persons
(
    id varchar NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    second_name VARCHAR(255),
    surname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    date_birth DATE,
    is_delete BOOLEAN,
    CONSTRAINT user_pk PRIMARY KEY (id)
    );