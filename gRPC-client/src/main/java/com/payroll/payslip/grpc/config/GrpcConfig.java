package com.payroll.payslip.grpc.config;

import com.payroll.payslip.grpc.client.PersonGrpcClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    @Qualifier("personChannel")
    private ManagedChannel personChannel;

    @Autowired
    @Qualifier("organizationChannel")
    private ManagedChannel organizationChannel;

    @Autowired
    @Qualifier("employeeChannel")
    private ManagedChannel employeeChannel;

    @PreDestroy
    public void shutdownChannels() {
        personChannel.shutdown();
        organizationChannel.shutdown();
        employeeChannel.shutdown();
    }
}
