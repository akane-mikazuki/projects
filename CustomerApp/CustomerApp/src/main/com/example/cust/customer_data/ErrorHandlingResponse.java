package com.example.cust.customer_data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorHandlingResponse {
    private int transactionStatusCode;
    private String transactionStatusDescription;
    
    public ErrorHandlingResponse(int transactionStatusCode, String transactionStatusDescription) {
        this.transactionStatusCode = transactionStatusCode;
        this.transactionStatusDescription = transactionStatusDescription;
    }
}
