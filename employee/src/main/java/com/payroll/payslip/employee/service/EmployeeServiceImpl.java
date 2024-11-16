package com.payroll.payslip.employee.service;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.payroll.payslip.employee.model.dto.CreateEmployeeRequest;
import com.payroll.payslip.employee.model.dto.CreateEmployeeResponse;
import com.payroll.payslip.employee.model.dto.DismissEmployeeRequest;
import com.payroll.payslip.employee.model.dto.DismissEmployeeResponse;
import com.payroll.payslip.employee.model.dto.EmployeeResponse;
import com.payroll.payslip.employee.model.dto.UpdateEmployeeRequest;
import com.payroll.payslip.employee.model.dto.UpdateEmployeeResponse;
import com.payroll.payslip.employee.persistence.repository.EmployeePostgresRepository;
import com.payroll.payslip.employee.service.mapper.EmployeeDtoToEntityMapper;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeDtoToEntityMapper mapper = EmployeeDtoToEntityMapper.INSTANCE;
  private final EmployeePostgresRepository repository;

  @Override
  public CreateEmployeeResponse createEmployee(CreateEmployeeRequest request) {
    return mapper.mapToCreateResponse(repository.save(mapper.createEmplMapToEntity(request)));
  }

  @Override
  public UpdateEmployeeResponse updateEmployee(Long id, UpdateEmployeeRequest request) {
    return null;
  }

  @Override
  public DismissEmployeeResponse dismissEmployee(Long id, DismissEmployeeRequest request) {
    return null;
  }

  @Override
  public EmployeeResponse findEmployeeById(Long id) {
    return null;
  }

  @Override
  public List<EmployeeResponse> findAllEmployeesByOrganizationId(Long organizationId) {
    return List.of();
  }

  @Override
  public List<EmployeeResponse> findAllEmployees() {
    return List.of();
  }
}
