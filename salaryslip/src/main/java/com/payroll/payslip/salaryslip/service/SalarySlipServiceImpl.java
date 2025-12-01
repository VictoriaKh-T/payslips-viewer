package com.payroll.payslip.salaryslip.service;

import com.payroll.payslip.salaryslip.model.MonthOfYear;
import com.payroll.payslip.salaryslip.model.dto.CreateSalarySlipRequest;
import com.payroll.payslip.salaryslip.model.dto.SalarySlipResponse;
import com.payroll.payslip.salaryslip.model.entity.SalarySlipEntity;
import com.payroll.payslip.salaryslip.persistence.repository.SalarySlipPostgresRepository;
import com.payroll.payslip.salaryslip.service.mapper.SalarySlipDto2Entity;
import com.payroll.payslip.salaryslip.service.mapper.SalarySlipEntity2Dto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalarySlipServiceImpl implements SalarySlipService {

    private final SalarySlipPostgresRepository repository;
    private final SalarySlipDto2Entity mapperToEntity = SalarySlipDto2Entity.INSTANCE;
    private final SalarySlipEntity2Dto mapperToDto = SalarySlipEntity2Dto.INSTANCE;

    @Override
    public List<SalarySlipResponse> findAll() {
        return repository.findAll().stream()
                .map(mapperToDto::mapSalarySlipToDto)
                .toList();
    }

    @Override
    public SalarySlipResponse create(CreateSalarySlipRequest request) {
        SalarySlipEntity entity = new SalarySlipEntity();
        entity.setYear(request.year());
        entity.setEmployee_id(request.employee_id());
        entity.setMonthOfYear(MonthOfYear.valueOf(request.monthOfYear().toUpperCase()));
        entity.setFilePath(request.filePath());

        return mapperToDto.mapSalarySlipToDto(repository.save(entity));
    }

    @Override
    public List<SalarySlipResponse> findByEmployeeId(Long employeeId) {
        return repository.findByEmployeeId(employeeId).stream()
                .map(mapperToDto::mapSalarySlipToDto)
                .toList();
    }

    @Override
    public List<SalarySlipResponse> findByYearAndMonth(int year, MonthOfYear monthOfYear) {
        return repository.findByYearAndMonth(year, monthOfYear).stream()
                .map(mapperToDto::mapSalarySlipToDto)
                .toList();
    }
}
