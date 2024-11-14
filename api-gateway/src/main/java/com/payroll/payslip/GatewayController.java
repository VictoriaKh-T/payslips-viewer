package com.payroll.payslip;

import com.payroll.payslip.proto.CreateEmployeeResponse;
import com.payroll.payslip.proto.EmployeeDataServiceGrpc;
import com.payroll.payslip.proto.PersonDataServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class GatewayController {

    private final ManagedChannel personChannel;
    private final PersonDataServiceGrpc.PersonDataServiceBlockingStub personStub;

    private final ManagedChannel employeeChannel;
    private final EmployeeDataServiceGrpc.EmployeeDataServiceBlockingStub employeeStub;

    public GatewayController() {
        // Налаштовуємо gRPC канали для з'єднання з сервісами
        personChannel = ManagedChannelBuilder.forAddress("localhost", 50052)
                .usePlaintext()
                .build();
        personStub = PersonDataServiceGrpc.newBlockingStub(personChannel);

        employeeChannel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        employeeStub = EmployeeDataServiceGrpc.newBlockingStub(employeeChannel);
    }

    @PostMapping("/createEmployee")
    public CreateEmployeeResponse createEmployee(@RequestParam int personId) {

//        GetPersonRequest personRequest = GetPersonRequest.newBuilder().setPersonId(personId).build();
//        GetPersonResponse personResponse = personStub.getPersonById(personRequest);
//
//        String fullName = personResponse.getPerson().getFirstName() + " " + personResponse.getPerson().getSureName();
//
//        CreateEmployeeRequest employeeRequest = CreateEmployeeRequest.newBuilder()
//                .setFullName(fullName)
//                .setPersonId(personId)
//                .build();
//
//        return employeeStub.createEmployeeViaPerson(employeeRequest);
        return null;
    }
}
