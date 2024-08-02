package com.example.cust.customer_service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.cust.customer_data.AccountResponse;
import com.example.cust.customer_data.GetCustomerByIdResponse;
import com.example.cust.customer_model.CustomerModel;

@Service
public class GetCustomerService {

    private final int SUCCESS_CODE = 302;
    private final String SUCCESS_CODE_DESC = "Customer Account found.";

    public GetCustomerByIdResponse getExistingCustomer(CustomerModel customerModel) {

        AccountResponse accountResponse = new AccountResponse();

        //set up response for successful retrieval
        GetCustomerByIdResponse response = new GetCustomerByIdResponse();
        response.setCustomerNumber(customerModel.getCustomerNumber());
        response.setCustomerName(customerModel.getCustomerName());
        response.setCustomerMobile(customerModel.getCustomerMobile());
        response.setCustomerEmail(customerModel.getCustomerEmail());
        response.setAddress1(customerModel.getAddress1());
        response.setAddress2(customerModel.getAddress2());

        //get all accounts

          List<AccountResponse> accounts = customerModel.getAccounts().stream().map(account -> {
              accountResponse.setAccountNumber(account.getAccountNumber());
              accountResponse.setAccountType(account.getAccountType());
              accountResponse.setAvailableBalance(account.getAvailableBalance());
              return accountResponse;
          }).collect(Collectors.toList());

        response.setAccounts(accounts);

        response.setTransactionStatusCode(SUCCESS_CODE);
        response.setTransactionStatusDescription(SUCCESS_CODE_DESC);

        return response;

    }
}
