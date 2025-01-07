package com.payroll.payslip.employee.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
@SQLDelete(sql = "UPDATE employees SET is_delete = true WHERE id = ?")
@Table(name = "employees")
@NoArgsConstructor
@Where(clause = "is_delete = false")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String fullName;

    @NonNull
    private LocalDate employmentDate;

    private LocalDate dismissDate;

    @NonNull
    private Long organizationId;

    @NonNull
    private Long personId;

    @Column(nullable = false)
    private boolean isDelete = false;
}
