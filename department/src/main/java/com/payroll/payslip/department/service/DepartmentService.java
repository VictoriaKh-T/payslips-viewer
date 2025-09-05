package com.payroll.payslip.department.service;

import com.payroll.payslip.department.model.dto.CreateDepartmentRequest;
import com.payroll.payslip.department.model.dto.CreateDepartmentResponse;
import com.payroll.payslip.department.model.dto.DepartmentResponse;
import com.payroll.payslip.department.model.dto.UpdateDepartmentRequest;
import com.payroll.payslip.department.model.dto.UpdateDepartmentResponse;
import java.util.List;

public interface DepartmentService {
    CreateDepartmentResponse createDepartment(CreateDepartmentRequest createDepartmentRequest);

    DepartmentResponse findDepartmentById(Long departmentId);

    UpdateDepartmentResponse updateDepartment(UpdateDepartmentRequest updateDepartmentRequest);

    List<DepartmentResponse> findAll();

    void deleteDepartmentById(Long organizationId);
}
