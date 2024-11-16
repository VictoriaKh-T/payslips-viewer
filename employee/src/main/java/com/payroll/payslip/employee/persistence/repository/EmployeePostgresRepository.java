package com.payroll.payslip.employee.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.payroll.payslip.employee.model.entity.EmployeeEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePostgresRepository extends JpaRepository<EmployeeEntity, Long> {}
