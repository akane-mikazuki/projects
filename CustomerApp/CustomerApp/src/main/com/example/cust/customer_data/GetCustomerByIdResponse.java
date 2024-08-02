package com.example.cust.customer_data;

import lombok.*;

import java.util.List;

@Setter
@Getter
public class GetCustomerByIdResponse {

private Long customerNumber;
private String customerName;
private String customerMobile;
private String customerEmail;
private String address1;
private String address2;
private List<AccountResponse> accounts;
private int transactionStatusCode;
private String transactionStatusDescription;

}
