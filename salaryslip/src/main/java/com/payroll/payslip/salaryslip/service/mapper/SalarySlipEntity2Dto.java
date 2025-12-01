package com.payroll.payslip.salaryslip.service.mapper;

import com.payroll.payslip.salaryslip.model.dto.SalarySlipResponse;
import com.payroll.payslip.salaryslip.model.entity.SalarySlipEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SalarySlipEntity2Dto {
    SalarySlipEntity2Dto INSTANCE = Mappers.getMapper(SalarySlipEntity2Dto.class);

    SalarySlipResponse mapSalarySlipToDto(SalarySlipEntity entity);
}
