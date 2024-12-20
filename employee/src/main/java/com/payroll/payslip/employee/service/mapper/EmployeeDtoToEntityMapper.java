package com.payroll.payslip.employee.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.payroll.payslip.employee.model.dto.CreateEmployeeRequest;
import com.payroll.payslip.employee.model.dto.CreateEmployeeResponse;
import com.payroll.payslip.employee.model.dto.DismissEmployeeResponse;
import com.payroll.payslip.employee.model.dto.EmployeeResponse;
import com.payroll.payslip.employee.model.dto.UpdateEmployeeResponse;
import com.payroll.payslip.employee.model.entity.EmployeeEntity;

@Mapper
public interface EmployeeDtoToEntityMapper {
  EmployeeDtoToEntityMapper INSTANCE = Mappers.getMapper(EmployeeDtoToEntityMapper.class);

  EmployeeEntity createEmplMapToEntity(CreateEmployeeRequest request);

  CreateEmployeeResponse mapToCreateResponse(EmployeeEntity entity);

  UpdateEmployeeResponse mapToUpdateResponse(EmployeeEntity entity);

  DismissEmployeeResponse mapToDismissResponse(EmployeeEntity entity);

  EmployeeResponse mapToResponse(EmployeeEntity entity);
}
