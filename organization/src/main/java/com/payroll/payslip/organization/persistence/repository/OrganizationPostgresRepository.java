package com.payroll.payslip.organization.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.payroll.payslip.organization.model.entity.OrganizationEntity;

@Repository
public interface OrganizationPostgresRepository extends JpaRepository<OrganizationEntity, Long> {

  @Query("FROM OrganizationEntity o WHERE o.kodOrganization = ?1 ")
  Optional<OrganizationEntity> findByKodOrganization(String organizationKod);
}
