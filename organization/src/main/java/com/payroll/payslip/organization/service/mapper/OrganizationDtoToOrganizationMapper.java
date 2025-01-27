package com.payroll.payslip.organization.service.mapper;

import com.payroll.payslip.organization.model.dto.OrganizationRequest;
import com.payroll.payslip.organization.model.dto.OrganizationResponse;
import com.payroll.payslip.organization.model.dto.UpdateOrganizationResponse;
import com.payroll.payslip.organization.model.entity.OrganizationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrganizationDtoToOrganizationMapper {
    OrganizationDtoToOrganizationMapper INSTANCE = Mappers.getMapper(OrganizationDtoToOrganizationMapper.class);

    OrganizationEntity mapToEntity(OrganizationRequest request);

    OrganizationResponse mapToResponse(OrganizationEntity entity);

    UpdateOrganizationResponse mapToUpdateResponse(OrganizationEntity entity);
}
