package com.example.cust.customer_model;

import java.util.List;

import javax.persistence.*;
import org.hibernate.annotations.Parameter;

import org.hibernate.annotations.GenericGenerator;

import lombok.*;

@Entity
@Table(name="CustomerDb")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CustomerModel {

    @Id
    @GeneratedValue(generator = "seqgen")
    @GenericGenerator(
        name = "seqgen",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {@Parameter(name = "initial_value", value = "12345678"),
        @Parameter(name = "increment_size", value = "1")}
    )
    private Long customerNumber;
    
    private String customerName;
    private String customerMobile;
    private String customerEmail;
    private String address1;
    private String address2;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AccountModel> accounts;

}



