CREATE TABLE IF NOT EXISTS public.employees
    (
        id BIGINT PRIMARY KEY,
        full_name VARCHAR(255) NOT NULL,
        employment_date DATE,
        dismissal_date DATE,
        person_id bigint NOT NULL,
        organization_id bigint NOT NULL,
        is_delete BOOLEAN,
        CONSTRAINT fk_person FOREIGN KEY (person_id) REFERENCES persons(id),
        CONSTRAINT fk_organization FOREIGN KEY (organization_id) REFERENCES organizations(id)
);