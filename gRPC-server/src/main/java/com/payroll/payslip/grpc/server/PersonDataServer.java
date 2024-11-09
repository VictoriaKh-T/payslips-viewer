package com.payroll.payslip.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class PersonDataServer {

    public static void main(String[] args) throws InterruptedException, IOException {
        Server server = ServerBuilder.forPort(50053)
                .addService(new PersonDataServiceImpl())
                .build();
        System.out.println("Server started...");
        server.start();
        server.awaitTermination();
    }
}
