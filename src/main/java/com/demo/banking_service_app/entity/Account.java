package com.demo.banking_service_app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private int id;
    private String name;
    private String type;
    private LocalDate openDate;

}
