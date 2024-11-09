package com.payroll.payslip.grpc.server;

import com.payroll.payslip.proto.GetFullNameRequest;
import com.payroll.payslip.proto.GetFullNameResponse;
import com.payroll.payslip.proto.GetPersonRequest;
import com.payroll.payslip.proto.GetPersonResponse;
import com.payroll.payslip.proto.PersonDataServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class PersonDataServiceImpl extends PersonDataServiceGrpc.PersonDataServiceImplBase {

    @Override
    public void getPersonById(GetPersonRequest request, StreamObserver<GetPersonResponse> responseObserver) {
        super.getPersonById(request, responseObserver);
    }

    @Override
    public void cetFullNameByPersonId(GetFullNameRequest request, StreamObserver<GetFullNameResponse> responseObserver) {
        super.cetFullNameByPersonId(request, responseObserver);
    }
}
