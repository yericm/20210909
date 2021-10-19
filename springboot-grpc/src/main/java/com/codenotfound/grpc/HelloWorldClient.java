package com.codenotfound.grpc;

import com.codenotfound.grpc.helloworld.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author yeric
 * @description:
 * @date 2021/10/19 23:37
 */
@Component
@Slf4j
public class HelloWorldClient {

    private HelloWorldServiceGrpc.HelloWorldServiceBlockingStub helloWorldServiceBlockingStub;


    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();
        helloWorldServiceBlockingStub = HelloWorldServiceGrpc.newBlockingStub(managedChannel);
    }

    public String sayHello(String firstName, String lastName) {
        Person person = Person.newBuilder().setFirstName(firstName).setLastName(lastName).build();
        log.info("client sending {}", person);

        Greeting greeting = helloWorldServiceBlockingStub.sayHello(person);
        log.info("client received {}", greeting);

        return greeting.getMessage();
    }

    public int addOperation(int a, int b) {
        A1 a1 = A1.newBuilder().setA(a).setB(b).build();
        A2 a2 = helloWorldServiceBlockingStub.addOperation(a1);
        return a2.getMessage();
    }

}
