package com.payroll.payslip.salaryslip.model.entity;

import com.payroll.payslip.salaryslip.model.MonthOfYear;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
@SQLDelete(sql = "UPDATE salaryslips SET is_delete = true WHERE id = ?")
@Table(name = "salaryslips")
@NoArgsConstructor
@Where(clause = "is_delete = false")
public class SalarySlipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long employee_id;

    @Enumerated(EnumType.STRING)
    private MonthOfYear monthOfYear;

    private int year;

    @NotNull
    private String filePath;
}
