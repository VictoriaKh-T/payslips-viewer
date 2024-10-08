package com.payroll.payslip.organization.controller;

import java.util.List;
import com.payroll.payslip.organization.model.dto.FindOrganizationByKodRequest;
import com.payroll.payslip.organization.model.dto.OrganizationRequest;
import com.payroll.payslip.organization.model.dto.OrganizationResponse;
import com.payroll.payslip.organization.model.dto.UpdateOrganizationRequest;
import com.payroll.payslip.organization.model.dto.UpdateOrganizationResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.payroll.payslip.organization.service.OrganizationService;

@Tag(name = "Organization management", description = "Endpoints for managing organization")
@RestController
@RequiredArgsConstructor
@RequestMapping("/organizations")
public class OrganizationController {

  private final OrganizationService service;

  @GetMapping
  @Tag(name = "Get organizations", description = "This endpoint get all organizations")
  public List<OrganizationResponse> findAllOrganizations() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  @Tag(name = "Get organization", description = "This endpoint get an organization by ID")
  public OrganizationResponse findOrganizationById(@PathVariable Long id) {
    return service.findByOrganizationId(id);
  }

  @GetMapping("/find_by_kod")
  @Tag(
      name = "Get organization",
      description = "This endpoint get an organization by organization_kod")
  public OrganizationResponse findOrganizationByKod(
      @RequestBody FindOrganizationByKodRequest organizationKod) {
    return service.findByOrganizationKod(organizationKod);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Tag(name = "Create new organization", description = "This endpoint create an organization")
  public OrganizationResponse createOrganization(@RequestBody OrganizationRequest request) {
    return service.createOrganization(request);
  }

  @PutMapping("/{id}")
  public UpdateOrganizationResponse updateOrganization(
      @PathVariable Long id, @RequestBody UpdateOrganizationRequest request) {
    return service.updateOrganizationById(id, request);
  }

  @DeleteMapping("/{id}")
  public void deleteOrganization(@PathVariable Long id) {
    service.deleteOrganizationById(id);
  }
}
