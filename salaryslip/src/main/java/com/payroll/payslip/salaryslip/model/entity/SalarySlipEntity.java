package com.payroll.payslip.salaryslip.model.entity;

import com.payroll.payslip.salaryslip.model.MonthOfYear;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
@SQLDelete(sql = "UPDATE salaryslips SET is_delete = true WHERE id = ?")
@Table(name = "salaryslips")
@Where(clause = "is_delete = false")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SalarySlipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long employeeId;

    @Enumerated(EnumType.STRING)
    private MonthOfYear monthOfYear;

    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "base_salary")
    private Double baseSalary;

    @Column(name = "tax")
    private Double tax;

    @Column(name = "net_salary")
    private Double netSalary;

    @Column(name = "hours_worked")
    private Integer hoursWorked;

    @Column(name = "hour_rate")
    private Double hourRate;

    @OneToMany(mappedBy = "salarySlip", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SalarySlipAdditionEntity> additions = new ArrayList<>();

    @Column(nullable = false)
    private boolean isDelete = false;
}
