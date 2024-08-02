package com.example.cust.customer_model;

import javax.persistence.*;
import org.hibernate.annotations.Parameter;

import org.hibernate.annotations.GenericGenerator;

import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AccountModel {

    @Id
    @GeneratedValue(generator = "accseqgen")
    @GenericGenerator(
        name = "accseqgen",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {@Parameter(name = "initial_value", value = "100001"),
        @Parameter(name = "increment_size", value = "1")}
    )
    private Long accountNumber;

    private String accountType;
    private double availableBalance;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerModel customer;
}
