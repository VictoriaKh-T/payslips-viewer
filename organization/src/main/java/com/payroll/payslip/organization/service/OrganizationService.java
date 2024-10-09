package com.payroll.payslip.organization.service;

import com.payroll.payslip.organization.model.dto.*;
import java.util.List;

public interface OrganizationService {
  OrganizationResponse createOrganization(OrganizationRequest organization);

  OrganizationResponse findByOrganizationId(Long organizationId);

  OrganizationResponse findByOrganizationKod(FindOrganizationByKodRequest organizationKod);

  UpdateOrganizationResponse updateOrganizationById(
      Long organization_Id, UpdateOrganizationRequest request);

  void deleteOrganizationById(Long organizationId);

  List<OrganizationResponse> findAll();
}
