package com.javatechie.aws.sns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;
import software.amazon.awssdk.services.sns.model.SubscribeRequest;
import software.amazon.awssdk.services.sns.model.SubscribeResponse;

@Service
public class SnsService {

    public static final String TOPIC = "";

    @Autowired
    private SnsClient snsClient;

    // protocol: email or sms, endpoint: email_id or mobile number
    public String autoSubscription(String protocol, String endpoint) {
        SubscribeRequest subscribeRequest = SubscribeRequest.builder()
                .topicArn(TOPIC)
                .protocol(protocol)
                .endpoint(endpoint)
                .build();

        SubscribeResponse subscribe = snsClient.subscribe(subscribeRequest);
        return subscribe.subscriptionArn();
    }

    public String publishMessage(String message) {
        PublishRequest publishRequest = PublishRequest.builder()
                .topicArn(TOPIC)
                .message(message)
                .build();
        PublishResponse publish = snsClient.publish(publishRequest);
        return publish.messageId();
    }
}
