CREATE TABLE IF NOT EXISTS public.organizations
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    kod_organization VARCHAR(255) NOT NULL,
    telephone_number VARCHAR(255),
    description TEXT,
    is_delete BOOLEAN,
    CONSTRAINT unique_kod_organization UNIQUE (kod_organization),
    CONSTRAINT unique_name UNIQUE (name)
);