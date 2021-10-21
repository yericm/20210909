package com.example.grpc;

import io.grpc.stub.StreamObserver;

/**
 * @author yeric
 * @description:
 * @date 2021/10/20 00:15
 */
public class HelloService extends HelloServiceGrpc.HelloServiceImplBase{

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println( request );

        String greeting = "Hi " + request.getName() + " you are " + request.getAge() + " years old" +
                " your hoby is " + (request.getHobbiesList()) + " your tags " + request.getTagsMap();

        HelloResponse response = HelloResponse.newBuilder().setGreeting( greeting ).build();
        responseObserver.onNext( response );
        responseObserver.onCompleted();
    }
}