package com.payroll.payslip.person.service.mapper;

import com.payroll.payslip.person.model.dto.PersonResponse;
import com.payroll.payslip.person.model.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonEntity2Dto {

  PersonEntity2Dto INSTANCE = Mappers.getMapper(PersonEntity2Dto.class);

  PersonResponse mapToPersonResponse(PersonEntity entity);
}
