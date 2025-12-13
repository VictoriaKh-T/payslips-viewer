package com.payroll.payslip.salaryslip.service.mapper;

import com.payroll.payslip.salaryslip.model.dto.CreateSalarySlipRequestDto;
import com.payroll.payslip.salaryslip.model.entity.SalarySlipEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SalarySlipDto2Entity {
    SalarySlipDto2Entity INSTANCE = Mappers.getMapper(SalarySlipDto2Entity.class);

    @ValueMapping(target = "monthOfYear", source = "monthOfYear")
    SalarySlipEntity mapToEntity(CreateSalarySlipRequestDto request);
}
