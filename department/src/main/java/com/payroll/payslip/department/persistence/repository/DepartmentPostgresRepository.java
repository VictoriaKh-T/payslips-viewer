package com.payroll.payslip.department.persistence.repository;

import com.payroll.payslip.department.model.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentPostgresRepository extends JpaRepository<DepartmentEntity, Long> {}
