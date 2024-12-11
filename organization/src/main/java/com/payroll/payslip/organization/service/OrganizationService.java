package com.payroll.payslip.organization.service;

import java.util.List;

import com.payroll.payslip.organization.model.dto.*;

public interface OrganizationService {
  OrganizationResponse createOrganization(OrganizationRequest organization);

  OrganizationResponse findByOrganizationId(Long organizationId);

  OrganizationResponse findByOrganizationKod(FindOrganizationByKodRequest organizationKod);

  UpdateOrganizationResponse updateOrganizationById(
      Long organization_Id, UpdateOrganizationRequest request);

  void deleteOrganizationById(Long organizationId);

  List<OrganizationResponse> findAll();
}
