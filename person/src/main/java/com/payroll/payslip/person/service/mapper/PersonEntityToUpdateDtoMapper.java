package com.payroll.payslip.person.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.payroll.payslip.person.model.dto.UpdatePersonResponse;
import com.payroll.payslip.person.model.entity.PersonEntity;

@Mapper
public interface PersonEntityToUpdateDtoMapper {

  PersonEntityToUpdateDtoMapper INSTANCE = Mappers.getMapper(PersonEntityToUpdateDtoMapper.class);

  UpdatePersonResponse mapToPersonUpdateResponse(PersonEntity entity);
}
