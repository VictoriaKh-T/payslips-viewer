package com.payroll.payslip.employee.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.payroll.payslip.employee.model.dto.CreateEmployeeRequestDto;
import com.payroll.payslip.proto.CreateEmployeeRequest;

@Mapper
public interface CreateEmployeeRequestProto {
  CreateEmployeeRequestProto INSTANCE = Mappers.getMapper(CreateEmployeeRequestProto.class);

  CreateEmployeeRequest CreateEmployeeRequestToProto(CreateEmployeeRequestDto dto);

  CreateEmployeeRequestDto CreateEmployeeProtoTOCreateEmployeeDto(
      CreateEmployeeRequest createEmployeeRequest);
}
