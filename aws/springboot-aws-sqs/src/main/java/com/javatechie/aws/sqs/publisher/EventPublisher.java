package com.javatechie.aws.sqs.publisher;

import com.javatechie.aws.sqs.dto.Product;
import io.awspring.cloud.sqs.operations.SendResult;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class EventPublisher {

    @Autowired
    private SqsTemplate sqsTemplate; // for Async send message

    @Autowired
    private SqsClient sqsClient; // for Sync send message

    private final String ENDPOINT = "https://sqs.ap-south-1.amazonaws.com/058264080432/MyQueue";


    public String publishEventAsync(Product p) throws ExecutionException, InterruptedException {

        CompletableFuture<SendResult<Product>> sendResultCompletableFuture = sqsTemplate.sendAsync(ENDPOINT, p);

        return "Message submitted Async to queue " + sendResultCompletableFuture.get().messageId().toString();
    }

    public String publishEvent(Product p) {
        SendMessageRequest sendMessageRequest = SendMessageRequest
                .builder()
                .queueUrl(ENDPOINT)
                .messageBody(p.toString())
                .build();

        SendMessageResponse sendMessageResponse = sqsClient.sendMessage(sendMessageRequest);
        return "Message submitted Sync to queue " + sendMessageResponse.messageId();
    }
}
