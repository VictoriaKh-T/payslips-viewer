package com.payroll.payslip.employee.controller;

import com.payroll.payslip.employee.model.dto.*;
import com.payroll.payslip.employee.service.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Employee management", description = "Endpoints for managing employee")
@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    @Tag(name = "Get employees", description = "This endpoint get all employees")
    public List<EmployeeResponse> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/organization/{organizationId}")
    @Tag(name = "Get employees by organization ID", description = "This endpoint gets all employees by organization")
    public List<EmployeeResponse> findEmployeeByOrganizationId(@PathVariable Long organizationId) {
        return employeeService.findAllEmployeesByOrganizationId(organizationId);
    }

    @GetMapping("/{id}")
    @Tag(name = "Get employee by ID", description = "Get employee by ID")
    public EmployeeResponse findEmployeeById(@PathVariable Long id) {
        return employeeService.findEmployeeById(id);
    }

    @DeleteMapping("dismiss/{id}")
    @Tag(name = "Delete employee by ID", description = "Delete employee by ID")
    public DismissEmployeeResponse deleteEmployeeById(
            @PathVariable Long id, @RequestBody DismissEmployeeRequest request) {
        return employeeService.dismissEmployee(id, request);
    }

    @PostMapping
    @Tag(name = "create new employee data", description = "This point create new employee")
    public CreateEmployeeResponseDto createEmployee(@RequestBody CreateEmployeeRequestDto request) {
        return employeeService.createEmployee(request);
    }

    @PutMapping("/{id}")
    @Tag(name = "update employee", description = "This point updates employee`s data")
    public UpdateEmployeeResponse updateEmployee(@PathVariable Long id, @RequestBody UpdateEmployeeRequest request) {
        return employeeService.updateEmployee(id, request);
    }
}
