package com.helm.helm_k8s.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private int id;
    private String name;
    private String email;
    private String gender;
}
