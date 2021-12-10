package com.demo.banking_service_app.entity;

import org.springframework.stereotype.Component;

@Component
public class Transaction {

    private int id;
    private String type;
    private double amount;
    private String description;
    private Account account;

}
