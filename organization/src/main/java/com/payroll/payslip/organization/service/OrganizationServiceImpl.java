package com.payroll.payslip.organization.service;

import com.payroll.payslip.organization.exception.OrganizationNotFoundException;
import com.payroll.payslip.organization.model.dto.*;
import com.payroll.payslip.organization.model.entity.OrganizationEntity;
import com.payroll.payslip.organization.persistence.repository.OrganizationPostgresRepository;
import com.payroll.payslip.organization.service.mapper.OrganizationDtoToOrganizationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

  private final OrganizationPostgresRepository organizationPostgresRepository;
  private final OrganizationDtoToOrganizationMapper mapper =
      OrganizationDtoToOrganizationMapper.INSTANCE;

  @Override
  public OrganizationResponse createOrganization(OrganizationRequest organizationRequest) {
    OrganizationEntity organization =
        organizationPostgresRepository.save(mapper.mapToEntity(organizationRequest));
    return mapper.mapToResponse(organization);
  }

  @Override
  public OrganizationResponse findByOrganizationId(Long organizationId) {
    OrganizationEntity organization =
        organizationPostgresRepository
            .findById(organizationId)
            .orElseThrow(
                () ->
                    new OrganizationNotFoundException(
                        "can`t find organization by id " + organizationId));
    return mapper.mapToResponse(organization);
  }

  @Override
  public OrganizationResponse findByOrganizationKod(FindOrganizationByKodRequest organizationKod) {
    return mapper.mapToResponse(
        organizationPostgresRepository
            .findByKodOrganization(organizationKod.organizationKod())
            .orElseThrow(
                () ->
                    new OrganizationNotFoundException(
                        "can`t find organization by kod" + organizationKod.organizationKod())));
  }

  @Override
  public UpdateOrganizationResponse updateOrganizationById(
      Long organization_Id, UpdateOrganizationRequest request) {
    OrganizationEntity organization =
        organizationPostgresRepository
            .findById(organization_Id)
            .orElseThrow(
                () ->
                    new OrganizationNotFoundException(
                        "can`t find organization by id" + organization_Id));
    organization.setKodOrganization(request.kodOrganization());
    organization.setName(request.name());
    organization.setAddress(request.address());
    organizationPostgresRepository.save(organization);
    return mapper.mapToUpdateResponse(organization);
  }

  @Override
  public void deleteOrganizationById(Long organizationId) {
    organizationPostgresRepository.deleteById(organizationId);
  }

  @Override
  public List<OrganizationResponse> findAll() {
    return organizationPostgresRepository.findAll().stream().map(mapper::mapToResponse).toList();
  }
}
