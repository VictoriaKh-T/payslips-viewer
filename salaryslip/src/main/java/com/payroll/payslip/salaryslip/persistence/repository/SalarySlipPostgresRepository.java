package com.payroll.payslip.salaryslip.persistence.repository;

import com.payroll.payslip.salaryslip.model.MonthOfYear;
import com.payroll.payslip.salaryslip.model.entity.SalarySlipEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalarySlipPostgresRepository extends JpaRepository<SalarySlipEntity, Long> {
    List<SalarySlipEntity> findByEmployeeId(Long employeeId);

    List<SalarySlipEntity> findByYearAndMonthOfYear(int year, MonthOfYear monthOfYear);

    Optional<SalarySlipEntity> findByEmployeeIdAndYearAndMonthOfYear(
            Long employeeId, int year, MonthOfYear monthOfYear);
}
