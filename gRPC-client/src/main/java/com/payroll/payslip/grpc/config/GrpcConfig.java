package com.payroll.payslip.grpc.config;

import com.payroll.payslip.proto.PersonDataServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfig {

    @Bean
    public ManagedChannel personChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 50053)
                .usePlaintext()
                .build();
    }

    @Bean
    public PersonDataServiceGrpc.PersonDataServiceBlockingStub personGrpcClient(ManagedChannel personChannel) {
        return PersonDataServiceGrpc.newBlockingStub(personChannel);
    }

    @Bean
    public ManagedChannel organizationChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 50052)
                .usePlaintext()
                .build();
    }

    @Bean
    public ManagedChannel employeeChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
    }

    @PreDestroy
    public void shutdownChannels(ManagedChannel personChannel, ManagedChannel organizationChannel, ManagedChannel employeeChannel) {
        personChannel.shutdown();
        organizationChannel.shutdown();
        employeeChannel.shutdown();
    }
}
