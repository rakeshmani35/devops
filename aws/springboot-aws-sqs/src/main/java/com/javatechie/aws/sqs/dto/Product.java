package com.javatechie.aws.sqs.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

    private Long productId;
    private String productName;
    private int quantity;
    private Double price;
    private Double discount;
    private Double totalAmount;

}
