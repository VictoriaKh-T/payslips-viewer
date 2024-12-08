package com.payroll.payslip.employee.service;

import java.util.List;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.payroll.payslip.employee.exception.EmployeeNotFoundException;
import com.payroll.payslip.employee.model.dto.CreateEmployeeRequestDto;
import com.payroll.payslip.employee.model.dto.CreateEmployeeResponseDto;
import com.payroll.payslip.employee.model.dto.DismissEmployeeRequest;
import com.payroll.payslip.employee.model.dto.DismissEmployeeResponse;
import com.payroll.payslip.employee.model.dto.EmployeeResponse;
import com.payroll.payslip.employee.model.dto.UpdateEmployeeRequest;
import com.payroll.payslip.employee.model.dto.UpdateEmployeeResponse;
import com.payroll.payslip.employee.model.entity.EmployeeEntity;
import com.payroll.payslip.employee.persistence.repository.EmployeePostgresRepository;
import com.payroll.payslip.employee.service.mapper.CreateEmployeeRequestProto;
import com.payroll.payslip.employee.service.mapper.CreateEmployeeResponse2Proto;
import com.payroll.payslip.employee.service.mapper.EmployeeDtoToEntityMapper;
import com.payroll.payslip.grpc.client.EmployeeGrpcClient;
import com.payroll.payslip.grpc.client.PersonGrpcClient;
import com.payroll.payslip.proto.CreateEmployeeResponse;
import com.payroll.payslip.proto.GetPersonResponse;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeDtoToEntityMapper mapper = EmployeeDtoToEntityMapper.INSTANCE;
  private final CreateEmployeeRequestProto createEmployeeRequestProto =
      CreateEmployeeRequestProto.INSTANCE;
  private final CreateEmployeeResponse2Proto createEmployeeResponse2Proto =
      CreateEmployeeResponse2Proto.INSTANCE;
  private final EmployeePostgresRepository repository;
  private final PersonGrpcClient personGrpcClient;
  private final EmployeeGrpcClient employeeGrpcClient;

  @Override
  public CreateEmployeeResponseDto createEmployee(CreateEmployeeRequestDto request) {
    GetPersonResponse person = personGrpcClient.getPersonById(request.personId());

    CreateEmployeeResponse employeeProtoResponse =
        employeeGrpcClient.createEmployee(
            createEmployeeRequestProto.CreateEmployeeRequestToProto(request));
    CreateEmployeeResponseDto responseDto =
        createEmployeeResponse2Proto.toCreateEmployeeResponseDto(employeeProtoResponse);
    EmployeeEntity employeeEntity = mapper.createEmployeeResponseToEntity(responseDto);
    return mapper.mapToCreateResponse(repository.save(employeeEntity));
  }

  @Override
  public UpdateEmployeeResponse updateEmployee(Long employeeId, UpdateEmployeeRequest request) {
    EmployeeEntity employeeEntity =
        repository
            .findById(employeeId)
            .orElseThrow(
                () -> new EmployeeNotFoundException("can`t find employee by id " + employeeId));
    employeeEntity.setPersonId(request.personId());
    employeeEntity.setOrganizationId(request.organizationId());
    employeeEntity.setFulltName(request.fullName());
    employeeEntity.setEmploymentDate(request.emplDate());
    employeeEntity.setDismissDate(request.disDate());
    repository.save(employeeEntity);
    return mapper.mapToUpdateResponse(employeeEntity);
  }

  @Override
  public DismissEmployeeResponse dismissEmployee(Long employeeId, DismissEmployeeRequest request) {
    EmployeeEntity employeeEntity =
        repository
            .findById(employeeId)
            .orElseThrow(
                () -> new EmployeeNotFoundException("can`t find employee by id " + employeeId));
    employeeEntity.setDismissDate(request.dismissDate());
    repository.save(employeeEntity);
    return mapper.mapToDismissResponse(employeeEntity);
  }

  @Override
  public EmployeeResponse findEmployeeById(Long employeeId) {
    return mapper.mapToResponse(
        repository
            .findById(employeeId)
            .orElseThrow(
                () -> new EmployeeNotFoundException("can`t find employee by id " + employeeId)));
  }

  @Override
  public List<EmployeeResponse> findAllEmployeesByOrganizationId(Long organizationId) {
    return List.of();
  }

  @Override
  public List<EmployeeResponse> findAllEmployees() {
    return repository.findAll().stream().map(mapper::mapToResponse).toList();
  }
}
