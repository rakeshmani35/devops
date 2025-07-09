package com.javatechie.aws.sqs.controller;

import com.javatechie.aws.sqs.dto.Product;
import com.javatechie.aws.sqs.publisher.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/sqs")
public class EventController {

    @Autowired
    private EventPublisher eventPublisher;

    @PostMapping("/async/publish")
    public String publishEventAsync(@RequestBody Product p) throws ExecutionException, InterruptedException {
        return eventPublisher.publishEventAsync(p);
    }

    @PostMapping("/sync/publish")
    public String publishEventSync(@RequestBody Product p) {
        return eventPublisher.publishEvent(p);
    }
}
