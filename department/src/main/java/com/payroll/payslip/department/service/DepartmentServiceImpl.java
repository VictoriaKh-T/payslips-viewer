package com.payroll.payslip.department.service;

import com.payroll.payslip.department.exception.DepartmentNotFoundException;
import com.payroll.payslip.department.model.dto.CreateDepartmentRequest;
import com.payroll.payslip.department.model.dto.CreateDepartmentResponse;
import com.payroll.payslip.department.model.dto.DepartmentResponse;
import com.payroll.payslip.department.model.dto.UpdateDepartmentRequest;
import com.payroll.payslip.department.model.dto.UpdateDepartmentResponse;
import com.payroll.payslip.department.model.entity.DepartmentEntity;
import com.payroll.payslip.department.persistence.repository.DepartmentPostgresRepository;
import com.payroll.payslip.department.service.mapper.DepartmentDtoToEntityMapper;
import com.payroll.payslip.department.service.mapper.DepartmentEntityToDtoMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentPostgresRepository repository;
    private final DepartmentDtoToEntityMapper dtoToEntityMapper = DepartmentDtoToEntityMapper.INSTANCE;
    private final DepartmentEntityToDtoMapper entityToDtoMapper = DepartmentEntityToDtoMapper.INSTANCE;

    @Override
    public CreateDepartmentResponse createDepartment(CreateDepartmentRequest createDepartmentRequest) {
        DepartmentEntity department = repository.save(dtoToEntityMapper.createDtoMapToEntity(createDepartmentRequest));
        return entityToDtoMapper.mapToCreateDtoResponse(department);
    }

    @Override
    public DepartmentResponse findDepartmentById(Long departmentId) {
        DepartmentEntity department = repository
                .findById(departmentId)
                .orElseThrow(() -> new DepartmentNotFoundException("can`t find department by id " + departmentId));

        return entityToDtoMapper.mapToResponseDto(department);
    }

    @Override
    public UpdateDepartmentResponse updateDepartment(UpdateDepartmentRequest updateDepartmentRequest) {
        DepartmentEntity department = repository
                .findById(updateDepartmentRequest.id())
                .orElseThrow(() ->
                        new DepartmentNotFoundException("can`t find department by id " + updateDepartmentRequest.id()));

        department.setName(updateDepartmentRequest.name());
        department.setOrganizationId(updateDepartmentRequest.organizationId());
        return entityToDtoMapper.mapToUpdateDtoResponse(repository.save(department));
    }

    @Override
    public List<DepartmentResponse> findAll() {
        return repository.findAll().stream()
                .map(entityToDtoMapper::mapToResponseDto)
                .toList();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        repository.deleteById(departmentId);
    }
}
