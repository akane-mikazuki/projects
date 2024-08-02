package com.example.cust.customer_data;

import lombok.*;

@Getter
@Setter
public class CreateCustomerResponse {

    private Long customerNumber;
    private int transactionStatusCode;
    private String transactionStatusDescription;
    
    public CreateCustomerResponse(Long customerNumber, int transactionStatusCode, String transactionStatusDescription) {
        this.customerNumber = customerNumber;
        this.transactionStatusCode = transactionStatusCode;
        this.transactionStatusDescription = transactionStatusDescription;
    }

}
