package com.javatechie.aws.sqs.consumer;

import com.javatechie.aws.sqs.dto.Product;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Eventconsumer {

    @SqsListener("MyQueue")
    public void consumeMessage(@Payload Product p) {
        System.out.println("Received event message: " + p);
    }
}
