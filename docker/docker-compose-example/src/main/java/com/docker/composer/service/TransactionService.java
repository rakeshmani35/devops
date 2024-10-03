package com.docker.composer.service;

import com.docker.composer.entity.Payment;
import com.docker.composer.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    private PaymentRepository repository;

    public Payment addPayment(Payment payment){
        payment.setId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(payment);
    }

    public List<Payment> viewAllPayments(){
        return repository.findAll();
    }

    public Payment viewPayment(String transactionId) {
        Optional<Payment> optionalPayment = repository.findById(transactionId);
        return optionalPayment.orElseThrow(() -> new RuntimeException("Payment with transaction ID " + transactionId + " not found"));
    }
}
