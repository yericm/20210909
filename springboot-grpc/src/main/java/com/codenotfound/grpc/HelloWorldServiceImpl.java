package com.codenotfound.grpc;

import com.codenotfound.grpc.helloworld.*;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;

/**
 * @author yeric
 * @description:
 * @date 2021/10/19 23:33
 */
@GRpcService
@Slf4j
public class HelloWorldServiceImpl extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

    @Override
    public void sayHello(Person request,
                         StreamObserver<Greeting> responseObserver) {
        log.info("server received {}", request);

        String message = "Hello " + request.getFirstName() + " "
                + request.getLastName() + "!";
        Greeting greeting
                = Greeting.newBuilder().setMessage(message).build();
        log.info("server responded {}", greeting);
        System.out.println("message>>>" + message);
        responseObserver.onNext(greeting);
        responseObserver.onCompleted();
    }

    @Override
    public void addOperation(A1 request,
                             StreamObserver<A2> responseObserver) {
        log.info("server received {}", request);

        int message = request.getA() + request.getB();
        A2 a2 = A2.newBuilder().setMessage(message).build();
        log.info("server responded {}", a2);
        System.out.println("message>>>" + message);
        responseObserver.onNext(a2);
        responseObserver.onCompleted();
    }
}
