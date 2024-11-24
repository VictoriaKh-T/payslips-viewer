package com.payroll.payslip.employee.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payroll.payslip.employee.model.entity.EmployeeEntity;

@Repository
public interface EmployeePostgresRepository extends JpaRepository<EmployeeEntity, Long> {}
