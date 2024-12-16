package com.payroll.payslip.grpc.server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class EmployeeDataServer {

  public static void main(String[] args) throws InterruptedException, IOException {
    Server server = ServerBuilder.forPort(50051).addService(new EmployeeDataServiceImpl()).build();
    System.out.println("Server 50051 started...");
    server.start();
    server.awaitTermination();
  }
}
