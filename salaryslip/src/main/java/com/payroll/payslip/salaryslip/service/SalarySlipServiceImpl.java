package com.payroll.payslip.salaryslip.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payroll.payslip.salaryslip.model.MonthOfYear;
import com.payroll.payslip.salaryslip.model.dto.CreateSalarySlipRequestDto;
import com.payroll.payslip.salaryslip.model.dto.SalarySlipResponse;
import com.payroll.payslip.salaryslip.model.entity.SalarySlipAdditionEntity;
import com.payroll.payslip.salaryslip.model.entity.SalarySlipEntity;
import com.payroll.payslip.salaryslip.persistence.repository.SalarySlipPostgresRepository;
import com.payroll.payslip.salaryslip.service.mapper.SalarySlipDto2Entity;
import com.payroll.payslip.salaryslip.service.mapper.SalarySlipEntity2Dto;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    public void uploadZipFile(MultipartFile file) throws IOException {
        Path tempDir = Files.createTempDirectory("payslips");
        List<CreateSalarySlipRequestDto> dtos = new ArrayList<>();

        try (ZipInputStream zis = new ZipInputStream(file.getInputStream())) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if (!entry.isDirectory() && entry.getName().endsWith(".json")) {

                    Path filePath = tempDir.resolve(entry.getName());
                    Files.copy(zis, filePath, StandardCopyOption.REPLACE_EXISTING);

                    CreateSalarySlipRequestDto dto =
                            new ObjectMapper().readValue(filePath.toFile(), CreateSalarySlipRequestDto.class);

                    dtos.add(dto);
                }
            }
        }

        for (CreateSalarySlipRequestDto json : dtos) {
            SalarySlipEntity entity = new SalarySlipEntity();
            entity.setEmployeeId(json.getEmployeeId());
            entity.setEmployeeName(json.getEmployeeName());
            entity.setMonthOfYear(MonthOfYear.valueOf(json.getMonthOfYear().toUpperCase()));
            entity.setYear(json.getYear());
            entity.setBaseSalary(json.getBaseSalary());
            entity.setTax(json.getTax());
            entity.setNetSalary(json.getNetSalary());
            entity.setHoursWorked(json.getHoursWorked());
            entity.setHourRate(json.getHourRate());

            if (json.getExtras() != null) {
                for (Map.Entry<String, Double> entry : json.getExtras().entrySet()) {
                    SalarySlipAdditionEntity addition = new SalarySlipAdditionEntity();
                    addition.setCode(entry.getKey());
                    addition.setAmount(entry.getValue());
                    addition.setSalarySlip(entity);
                    entity.getAdditions().add(addition);
                }
            }
            repository.save(entity);
        }
    }

    @Override
    public SalarySlipResponse findByEmployeeIdAndYearAndMonthOfYear(
            Long employeeId, int year, MonthOfYear monthOfYear) {

        return repository
                .findByEmployeeIdAndYearAndMonthOfYear(employeeId, year, monthOfYear)
                .map(mapperToDto::mapSalarySlipToDto)
                .orElse(null);
    }

    @Override
    public List<SalarySlipResponse> findByEmployeeId(Long employeeId) {
        return repository.findByEmployeeId(employeeId).stream()
                .map(mapperToDto::mapSalarySlipToDto)
                .toList();
    }

    @Override
    public List<SalarySlipResponse> findByYearAndMonth(int year, MonthOfYear monthOfYear) {
        return repository.findByYearAndMonthOfYear(year, monthOfYear).stream()
                .map(mapperToDto::mapSalarySlipToDto)
                .toList();
    }
}
