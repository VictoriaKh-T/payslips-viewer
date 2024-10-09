package com.payroll.payslip.person.controller;

import java.time.LocalDate;
import java.util.List;
import com.payroll.payslip.person.model.dto.CreatePersonRequest;
import com.payroll.payslip.person.model.dto.CreatePersonResponse;
import com.payroll.payslip.person.model.dto.PersonResponse;
import com.payroll.payslip.person.model.dto.UpdatePersonRequest;
import com.payroll.payslip.person.model.dto.UpdatePersonResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.payroll.payslip.person.service.PersonService;

@Tag(name = "User management", description = "Endpoints for managing organization")
@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {
    private final PersonService service;

    @GetMapping
    @Tag(name = "Get persons", description = "This endpoint get all persons")
    public List<PersonResponse> findAllOrganizations() {
        return service.findAllPersons();
    }

    @GetMapping("/findByEmail")
    @Tag(name = "Get persons", description = "This endpoint get person by email")
    public PersonResponse findPersonByEmail(@RequestParam String email) {
        return service.findPersonByEmail(email);
    }

    @GetMapping("/{id}")
    @Tag(name = "Get persons", description = "This endpoint get person by id")
    public PersonResponse findPersonById(@PathVariable Long id) {
        return service.findPersonById(id);
    }

    @GetMapping("/findByDate")
    @Tag(name = "Get persons", description = "This endpoint get person by birth date")
    public PersonResponse findByDate(@RequestParam LocalDate date) {
        return service.findPersonByBirth(date);
    }

    @PostMapping
    @Tag(name = "create new person data", description = "This point create new person")
    public CreatePersonResponse createPerson(@RequestBody CreatePersonRequest request) {
        return service.createPerson(request);
    }

    @PutMapping("/{id}")
    public UpdatePersonResponse updatePerson(@PathVariable Long id, @RequestBody UpdatePersonRequest userRequest) {
        return service.updatePerson(id, userRequest);
    }

    @DeleteMapping("/{id}")
    @Tag(name = "delete person", description = "This point delete person")
    public void deletePerson(@PathVariable Long id) {
        service.deletePersonById(id);
    }
}
