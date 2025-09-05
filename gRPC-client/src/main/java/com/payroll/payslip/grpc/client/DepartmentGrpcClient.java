package com.payroll.payslip.grpc.client;

import com.payroll.payslip.proto.DepartmentServiceGrpc;
import com.payroll.payslip.proto.GetDepartmentRequest;
import com.payroll.payslip.proto.GetDepartmentResponse;
import io.grpc.ManagedChannel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DepartmentGrpcClient {
    private final DepartmentServiceGrpc.DepartmentServiceBlockingStub departmentStub;

    public DepartmentGrpcClient(@Qualifier("departmentChannel") ManagedChannel departmentChannel) {
        this.departmentStub = DepartmentServiceGrpc.newBlockingStub(departmentChannel);
    }

    public GetDepartmentResponse getDepartmentById(int departmentId) {
        GetDepartmentRequest request =
                GetDepartmentRequest.newBuilder().setId(departmentId).build();
        return departmentStub.getDepartment(request);
    }
}
