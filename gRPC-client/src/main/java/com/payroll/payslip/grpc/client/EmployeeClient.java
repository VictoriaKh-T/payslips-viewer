package com.payroll.payslip.grpc.client;

import com.payroll.payslip.proto.EmployeeDataServiceGrpc;
import com.payroll.payslip.proto.GetEmployeeRequest;
import com.payroll.payslip.proto.GetEmployeeResponse;
import com.payroll.payslip.proto.GetOrganizationRequest;
import com.payroll.payslip.proto.GetOrganizationResponse;
import com.payroll.payslip.proto.GetPersonRequest;
import com.payroll.payslip.proto.GetPersonResponse;
import com.payroll.payslip.proto.OrganizationDataServiceGrpc;
import com.payroll.payslip.proto.PersonDataServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class EmployeeClient {

    private final ManagedChannel employeeChannel;
    private final ManagedChannel organizationChannel;
    private final ManagedChannel personChannel;
    private final EmployeeDataServiceGrpc.EmployeeDataServiceBlockingStub employeeStub;
    private final OrganizationDataServiceGrpc.OrganizationDataServiceBlockingStub organizationStub;
    private final PersonDataServiceGrpc.PersonDataServiceBlockingStub personStub;

    public EmployeeClient(String host, int port, int employeePort, int organizationPort, int personPort) {
        employeeChannel = ManagedChannelBuilder.forAddress(host, employeePort)
                .usePlaintext()
                .build();
        organizationChannel = ManagedChannelBuilder.forAddress(host, organizationPort)
                .usePlaintext()
                .build();
        personChannel = ManagedChannelBuilder.forAddress(host, personPort)
                .usePlaintext()
                .build();

        employeeStub = EmployeeDataServiceGrpc.newBlockingStub(employeeChannel);
        organizationStub = OrganizationDataServiceGrpc.newBlockingStub(organizationChannel);
        personStub = PersonDataServiceGrpc.newBlockingStub(personChannel);
    }

    public void getEmployeeData(int employeeId) {
        GetEmployeeRequest request = GetEmployeeRequest.newBuilder().setEmployeeId(employeeId).build();
        GetEmployeeResponse response = employeeStub.getEmployeeById(request);
        System.out.println("Employee Data: " + response.getEmployee());
    }

    public void getOrganizationData(int organizationId) {
        GetOrganizationRequest request = GetOrganizationRequest.newBuilder().setOrganizationId(organizationId).build();
        GetOrganizationResponse response = organizationStub.getOrganizationById(request);
        System.out.println("Organization Data: " + response.getOrganization());
    }

    public void getPersonData(int personId) {
        GetPersonRequest request = GetPersonRequest.newBuilder().setPersonId(personId).build();
        GetPersonResponse response = personStub.getPersonById(request);
        System.out.println("Person Data: " + response.getPerson());
    }

    public void shutdown() {
        employeeChannel.shutdown();
        organizationChannel.shutdown();
        personChannel.shutdown();
    }
}
