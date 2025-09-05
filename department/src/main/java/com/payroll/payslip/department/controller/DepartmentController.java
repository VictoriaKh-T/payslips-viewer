package com.payroll.payslip.department.controller;

import com.payroll.payslip.department.model.dto.CreateDepartmentRequest;
import com.payroll.payslip.department.model.dto.CreateDepartmentResponse;
import com.payroll.payslip.department.model.dto.DepartmentResponse;
import com.payroll.payslip.department.model.dto.UpdateDepartmentRequest;
import com.payroll.payslip.department.model.dto.UpdateDepartmentResponse;
import com.payroll.payslip.department.service.DepartmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Department management", description = "Endpoints for managing departments")
@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;

    @GetMapping
    @Tag(name = "Get departments", description = "This endpoint gets all departments")
    public List<DepartmentResponse> findAllDepartments() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Tag(name = "Get department", description = "This endpoint gets a department by ID")
    public DepartmentResponse findDepartmentById(@PathVariable Long id) {
        return service.findDepartmentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Tag(name = "Create new department", description = "This endpoint creates a department")
    public CreateDepartmentResponse createDepartment(@RequestBody CreateDepartmentRequest request) {
        return service.createDepartment(request);
    }

    @PutMapping("/{id}")
    public UpdateDepartmentResponse updateDepartment(
            @PathVariable Long id, @RequestBody UpdateDepartmentRequest request) {
        return service.updateDepartment(request);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        service.deleteDepartmentById(id);
    }
}
