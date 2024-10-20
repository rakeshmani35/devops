package com.helm.helm_k8s.controller;

import com.helm.helm_k8s.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    @GetMapping
    public List<Customer> getAllCustomer() {
        log.info("kubernetes helm example .... start");

        log.info("kubernetes helm example .... end");

        return Stream.of(new Customer(101, "Rakesh", "rakesh@gmail.com", "male"),
                        new Customer(102, "Roshan", "roshan@gmail.com", "male"),
                        new Customer(1013, "Suchi", "suchi@gmail.com", "female"))
                .collect(Collectors.toList());
    }
}
