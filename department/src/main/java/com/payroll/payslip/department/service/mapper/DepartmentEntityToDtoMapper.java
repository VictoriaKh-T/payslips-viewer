package com.payroll.payslip.department.service.mapper;

import com.payroll.payslip.department.model.dto.CreateDepartmentResponse;
import com.payroll.payslip.department.model.dto.DepartmentResponse;
import com.payroll.payslip.department.model.dto.UpdateDepartmentResponse;
import com.payroll.payslip.department.model.entity.DepartmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentEntityToDtoMapper {
    DepartmentEntityToDtoMapper INSTANCE = Mappers.getMapper(DepartmentEntityToDtoMapper.class);

    CreateDepartmentResponse mapToCreateDtoResponse(DepartmentEntity entity);

    UpdateDepartmentResponse mapToUpdateDtoResponse(DepartmentEntity entity);

    DepartmentResponse mapToResponseDto(DepartmentEntity entity);
}
