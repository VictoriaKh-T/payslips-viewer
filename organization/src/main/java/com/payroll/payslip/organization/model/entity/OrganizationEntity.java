package com.payroll.payslip.organization.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "organizations")
@SQLDelete(sql = "UPDATE organizations SET is_delete = true WHERE id = ?")
@Entity
public class OrganizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String kodOrganization;

    private String address;
    private String telephoneNumber;
    private String description;

    @Column(nullable = false)
    private boolean isDelete = false;
}
