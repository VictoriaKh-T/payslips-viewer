package com.payroll.payslip.person.service;

import com.payroll.payslip.person.exception.PersonNotFoundException;
import com.payroll.payslip.person.model.dto.CreatePersonRequest;
import com.payroll.payslip.person.model.dto.CreatePersonResponse;
import com.payroll.payslip.person.model.dto.PersonResponse;
import com.payroll.payslip.person.model.dto.UpdatePersonRequest;
import com.payroll.payslip.person.model.dto.UpdatePersonResponse;
import com.payroll.payslip.person.model.entity.PersonEntity;
import com.payroll.payslip.person.persistence.repository.PersonPostgresRepository;
import com.payroll.payslip.person.service.mapper.PersonEntity2Dto;
import com.payroll.payslip.person.service.mapper.PersonEntityToCreateDtoMapper;
import com.payroll.payslip.person.service.mapper.PersonEntityToUpdateDtoMapper;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonPostgresRepository repository;
    private final PersonEntityToCreateDtoMapper createMapper = PersonEntityToCreateDtoMapper.INSTANCE;
    private final PersonEntityToUpdateDtoMapper updateMapper = PersonEntityToUpdateDtoMapper.INSTANCE;
    private final PersonEntity2Dto mapper = PersonEntity2Dto.INSTANCE;

    @Override
    public CreatePersonResponse createPerson(CreatePersonRequest request) {
        return createMapper.mapToCreateResponse(repository.save(createMapper.mapToEntity(request)));
    }

    @Override
    public UpdatePersonResponse updatePerson(Long personId, UpdatePersonRequest request) {
        PersonEntity person = repository
                .findById(personId)
                .orElseThrow(() -> new PersonNotFoundException("can`t find person by id " + personId));
        person.setBirthDate(request.birthDate());
        person.setEmail(request.email());
        person.setSurname(request.surname());
        person.setFirstName(request.firstName());
        person.setSecondName(request.secondName());
        return updateMapper.mapToPersonUpdateResponse(repository.save(person));
    }

    @Override
    public void deletePersonById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public PersonResponse findPersonByBirth(LocalDate birthDate) {
        PersonEntity person = repository
                .findPersonEntityByBirthDate(birthDate)
                .orElseThrow(() -> new PersonNotFoundException("person not found"));
        return mapper.mapToPersonResponse(person);
    }

    @Override
    public PersonResponse findPersonById(Long userId) {
        PersonEntity person = repository
                .findById(userId)
                .orElseThrow(() -> new PersonNotFoundException("can`t find person by id " + userId));
        return mapper.mapToPersonResponse(person);
    }

    @Override
    public PersonResponse findPersonByEmail(String email) {
        PersonEntity person = repository
                .findPersonEntityByEmail(email)
                .orElseThrow(() -> new PersonNotFoundException("person not found"));
        return mapper.mapToPersonResponse(person);
    }

    @Override
    public List<PersonResponse> findAllPersons() {
        return repository.findAll().stream().map(mapper::mapToPersonResponse).toList();
    }
}
