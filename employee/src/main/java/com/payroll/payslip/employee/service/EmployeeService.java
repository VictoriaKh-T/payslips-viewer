package com.payroll.payslip.employee.service;

import com.payroll.payslip.employee.model.dto.*;
import java.util.List;

public interface EmployeeService {
    CreateEmployeeResponseDto createEmployee(CreateEmployeeRequestDto request);

    UpdateEmployeeResponse updateEmployee(Long id, UpdateEmployeeRequest request);

    DismissEmployeeResponse dismissEmployee(Long id, DismissEmployeeRequest request);

    EmployeeResponse findEmployeeById(Long id);

    List<EmployeeResponse> findAllEmployeesByOrganizationId(Long organizationId);

    List<EmployeeResponse> findAllEmployees();
}
