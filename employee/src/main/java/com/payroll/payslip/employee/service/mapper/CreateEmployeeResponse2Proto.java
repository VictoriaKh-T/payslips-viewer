package com.payroll.payslip.employee.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.payroll.payslip.employee.model.dto.CreateEmployeeResponseDto;
import com.payroll.payslip.proto.CreateEmployeeResponse;

@Mapper
public interface CreateEmployeeResponse2Proto {
  CreateEmployeeResponse2Proto INSTANCE = Mappers.getMapper(CreateEmployeeResponse2Proto.class);

  CreateEmployeeResponse toCreateEmployeeResponse(CreateEmployeeResponseDto createEmployeeRequest);

  CreateEmployeeResponseDto toCreateEmployeeResponseDto(
      CreateEmployeeResponse createEmployeeRequest);
}
