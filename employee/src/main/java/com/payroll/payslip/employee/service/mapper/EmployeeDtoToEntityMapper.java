package com.payroll.payslip.employee.service.mapper;

import com.payroll.payslip.employee.model.dto.CreateEmployeeRequest;
import com.payroll.payslip.employee.model.dto.CreateEmployeeResponse;
import com.payroll.payslip.employee.model.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeDtoToEntityMapper {
    EmployeeDtoToEntityMapper INSTANCE =
            Mappers.getMapper(EmployeeDtoToEntityMapper.class);

    EmployeeEntity createEmplMapToEntity(CreateEmployeeRequest request);
    CreateEmployeeResponse mapToCreateResponse(EmployeeEntity entity);
}
