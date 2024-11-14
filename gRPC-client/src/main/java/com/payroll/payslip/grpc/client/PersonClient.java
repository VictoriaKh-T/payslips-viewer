package com.payroll.payslip.grpc.client;

import com.payroll.payslip.proto.GetPersonRequest;
import com.payroll.payslip.proto.GetPersonResponse;
import com.payroll.payslip.proto.PersonDataServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class PersonClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
        PersonDataServiceGrpc.PersonDataServiceStub stub = PersonDataServiceGrpc.newStub(channel);

        GetPersonRequest request = GetPersonRequest.newBuilder()
                .setPersonId(123)
                .build();

        stub.getPersonById(request, new StreamObserver<GetPersonResponse>() {
            @Override
            public void onNext(GetPersonResponse response) {
                System.out.println("Received response: " + response.getPerson());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Request completed.");
            }
        });

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        channel.shutdown();
    }
}
