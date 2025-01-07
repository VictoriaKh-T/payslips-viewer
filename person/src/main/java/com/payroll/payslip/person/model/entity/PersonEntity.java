package com.payroll.payslip.person.model.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
@SQLDelete(sql = "UPDATE persons SET is_delete = true WHERE id = ?")
@Table(name = "persons")
@NoArgsConstructor
@Where(clause = "is_delete = false")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    private String firstName;

    private String secondName;

    @NotNull
    private String surname;

    @NonNull
    private LocalDate birthDate;

    @Column(nullable = false)
    private boolean isDelete = false;
}
