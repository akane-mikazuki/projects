package com.example.cust.customer_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cust.customer_data.CreateCustomerRequest;
import com.example.cust.customer_model.AccountModel;
import com.example.cust.customer_model.CustomerModel;
import com.example.cust.customer_repo.CustomerAccountRepo;
import com.example.cust.customer_repo.CustomerRepo;


@Service
public class CreateCustomerService {

    @Autowired
    private CustomerAccountRepo customerAccountRepo;

    @Autowired
    private CustomerRepo customerRepo;

public CustomerModel createCustomer(CreateCustomerRequest customerRequest) {
 
    //populate the customer account table
    AccountModel account = new AccountModel();
    account.setAccountType(customerRequest.getAccountType().getCode().toString());
    //check if account type is savings
    if (customerRequest.getAccountType().getCode().equalsIgnoreCase("SAVINGS")) {
        //populate with mock data
        account.setAvailableBalance(500.00);
        
    }

    else if (customerRequest.getAccountType().getCode().equalsIgnoreCase("CHECKING")) {
        account.setAvailableBalance(5000.00);
    }

     CustomerModel customerModel = getCustomerModel(customerRequest);

    //save the data
    customerRepo.save(customerModel);

    account.setCustomer(customerModel);
    customerAccountRepo.save(account);

    return customerModel;

}

private CustomerModel getCustomerModel(CreateCustomerRequest customerRequest) {
    //create customer model
     CustomerModel customerModel = new CustomerModel();
     customerModel.setCustomerName(customerRequest.getCustomerName());
     customerModel.setCustomerMobile(customerRequest.getCustomerMobile());
     customerModel.setCustomerEmail(customerRequest.getCustomerEmail());
     customerModel.setAddress1(customerRequest.getAddress1());
     customerModel.setAddress2(customerRequest.getAddress2());
    return customerModel;
}


}
