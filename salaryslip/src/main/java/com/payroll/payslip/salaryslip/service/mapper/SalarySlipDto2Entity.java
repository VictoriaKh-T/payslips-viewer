package com.payroll.payslip.salaryslip.service.mapper;

import com.payroll.payslip.salaryslip.model.dto.CreateSalarySlipRequest;
import com.payroll.payslip.salaryslip.model.entity.SalarySlipEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SalarySlipDto2Entity {
    SalarySlipDto2Entity INSTANCE = Mappers.getMapper(SalarySlipDto2Entity.class);

    SalarySlipEntity mapToEntity(CreateSalarySlipRequest request);
}
