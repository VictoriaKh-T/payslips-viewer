package com.payroll.payslip.person.service;

import com.payroll.payslip.person.model.dto.CreatePersonRequest;
import com.payroll.payslip.person.model.dto.CreatePersonResponse;
import com.payroll.payslip.person.model.dto.PersonResponse;
import com.payroll.payslip.person.model.dto.UpdatePersonRequest;
import com.payroll.payslip.person.model.dto.UpdatePersonResponse;
import java.time.LocalDate;
import java.util.List;

public interface PersonService {
  CreatePersonResponse createPerson(CreatePersonRequest request);

  UpdatePersonResponse updatePerson(Long id, UpdatePersonRequest request);

  void deletePersonById(Long id);

  PersonResponse findPersonByBirth(LocalDate date);

  PersonResponse findPersonById(Long id);

  PersonResponse findPersonByEmail(String email);

  List<PersonResponse> findAllPersons();
}
