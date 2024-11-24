package com.payroll.payslip.grpc.server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class OrganizationDataServer {
  public static void main(String[] args) throws InterruptedException, IOException {
    Server server =
        ServerBuilder.forPort(50052).addService(new OrganizationDataServiceImpl()).build();
    System.out.println("Server started...");
    server.start();
    server.awaitTermination();
  }
}
