CREATE TABLE IF NOT EXISTS public.salaryslip
(
    id BIGINT PRIMARY KEY,
    filepath VARCHAR(255) NOT NULL,
    period VARCHAR(255),
    employee_id bigint NOT NULL,
    is_delete BOOLEAN
    );
