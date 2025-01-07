package com.payroll.payslip.employee.persistence.repository;

import com.payroll.payslip.employee.model.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePostgresRepository extends JpaRepository<EmployeeEntity, Long> {}
