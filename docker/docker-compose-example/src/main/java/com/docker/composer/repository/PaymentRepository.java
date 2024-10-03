package com.docker.composer.repository;


import com.docker.composer.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,String> {
}
