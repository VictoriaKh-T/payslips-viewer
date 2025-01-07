package com.payroll.payslip.person.service.mapper;

import com.payroll.payslip.person.model.dto.CreatePersonRequest;
import com.payroll.payslip.person.model.dto.CreatePersonResponse;
import com.payroll.payslip.person.model.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonEntityToCreateDtoMapper {

    PersonEntityToCreateDtoMapper INSTANCE = Mappers.getMapper(PersonEntityToCreateDtoMapper.class);

    PersonEntity mapToEntity(CreatePersonRequest request);

    CreatePersonResponse mapToCreateResponse(PersonEntity entity);
}
