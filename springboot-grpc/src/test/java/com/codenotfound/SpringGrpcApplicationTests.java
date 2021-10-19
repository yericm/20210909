package com.codenotfound;

import com.codenotfound.grpc.HelloWorldClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;

/**
 * @author yeric
 * @description:
 * @date 2021/10/19 23:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringGrpcApplicationTests {
    @Autowired
    private HelloWorldClient helloWorldClient;

    @Test
    public void testSayHello() {
        System.out.println("************");
        String str = helloWorldClient.sayHello("Grpc", "Java");
        int i = helloWorldClient.addOperation(1, 2);
        System.out.println(str);
        System.out.println(i);
    }
}
