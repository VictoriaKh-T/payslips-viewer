package com.payroll.payslip.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfiguration {

    @Bean(name = "personChannel")
    public ManagedChannel personChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 50053)
                .usePlaintext()
                .build();
    }

    @Bean(name = "organizationChannel")
    public ManagedChannel organizationChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 50052)
                .usePlaintext()
                .build();
    }

    @Bean(name = "employeeChannel")
    public ManagedChannel employeeChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
    }

    @Bean(name = "departmentChannel")
    public ManagedChannel departmentChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 50054)
                .usePlaintext()
                .build();
    }
}
