package com.grpcdemo.grpcdemoclient.service;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {
    @GrpcClient("myGrpcService")
    private com.grpcdemo.grpcdemoclient.grpc.GreeterGrpc.GreeterBlockingStub greeterBlockingStub;

    public String sayHello(String name) {
        com.grpcdemo.grpcdemoclient.grpc.HelloWorldProto.HelloRequest request = com.grpcdemo.grpcdemoclient.grpc.HelloWorldProto.HelloRequest.newBuilder()
                .setName(name)
                .build();
        com.grpcdemo.grpcdemoclient.grpc.HelloWorldProto.HelloReply reply = greeterBlockingStub.sayHello(request);
        return reply.getMessage();
    }
}
