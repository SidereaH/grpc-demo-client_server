package com.grpcdemo.grpcdemoserver.service;

import com.grpcdemo.grpcdemoserver.grpc.GreeterGrpc;
import com.grpcdemo.grpcdemoserver.grpc.HelloWorldProto;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloWorldService extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(
            HelloWorldProto.HelloRequest request,
            StreamObserver<HelloWorldProto.HelloReply> responseObserver) {
        String responseMessage = "hello " + request.getName();
        responseObserver.onNext(HelloWorldProto.HelloReply.newBuilder().setMessage(responseMessage).build());
        responseObserver.onCompleted();
    }
}
