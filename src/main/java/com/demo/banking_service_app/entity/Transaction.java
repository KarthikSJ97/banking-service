package com.demo.banking_service_app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    private int id;
    private String type;
    private double amount;
    private String description;
    private Account account;

}
