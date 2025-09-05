package com.payroll.payslip.department.service.mapper;

import com.payroll.payslip.department.model.dto.CreateDepartmentRequest;
import com.payroll.payslip.department.model.entity.DepartmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentDtoToEntityMapper {
    DepartmentDtoToEntityMapper INSTANCE = Mappers.getMapper(DepartmentDtoToEntityMapper.class);

    DepartmentEntity createDtoMapToEntity(CreateDepartmentRequest createDepartmentRequest);
}
