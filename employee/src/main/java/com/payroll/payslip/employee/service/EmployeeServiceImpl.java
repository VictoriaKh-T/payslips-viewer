package com.payroll.payslip.employee.service;

import com.payroll.payslip.employee.model.dto.CreateEmployeeRequest;
import com.payroll.payslip.employee.model.dto.CreateEmployeeResponse;
import com.payroll.payslip.employee.model.dto.DismissEmployeeRequest;
import com.payroll.payslip.employee.model.dto.DismissEmployeeResponse;
import com.payroll.payslip.employee.model.dto.EmployeeResponse;
import com.payroll.payslip.employee.model.dto.UpdateEmployeeRequest;
import com.payroll.payslip.employee.model.dto.UpdateEmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public CreateEmployeeResponse createEmployee(CreateEmployeeRequest request) {
        return null;
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
