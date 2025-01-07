package com.payroll.payslip.grpc.client;

import com.payroll.payslip.proto.GetPersonRequest;
import com.payroll.payslip.proto.GetPersonResponse;
import com.payroll.payslip.proto.PersonDataServiceGrpc;
import io.grpc.ManagedChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PersonGrpcClient {
    private static final Logger logger = LoggerFactory.getLogger(PersonGrpcClient.class);

    private final PersonDataServiceGrpc.PersonDataServiceBlockingStub personStub;

    public PersonGrpcClient(@Qualifier("personChannel") ManagedChannel personChannel) {
        this.personStub = PersonDataServiceGrpc.newBlockingStub(personChannel);
    }

    public GetPersonResponse getPersonById(long personId) {

        if (personStub == null) {
            logger.error("Person stub is not initialized");
            return null;
        }

        logger.info("Requesting person by ID: " + personId);
        logger.info("Using grpc server address: " + personStub.getChannel().toString());
        GetPersonRequest request = GetPersonRequest.newBuilder().setId(personId).build();
        logger.info(String.format("Server sent a response: %1s", request.getId()));
        return personStub.getPersonById(request);
    }
}
