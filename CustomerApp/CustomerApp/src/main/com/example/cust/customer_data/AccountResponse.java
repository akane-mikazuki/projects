package com.example.cust.customer_data;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountResponse {

private Long accountNumber;
private String accountType;
private double availableBalance;

}
