package com.example.cust.customer_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import org.springframework.web.bind.annotation.*;

import com.example.cust.CustomerValidation;
import com.example.cust.customer_data.CreateCustomerRequest;
import com.example.cust.customer_data.CreateCustomerResponse;
import com.example.cust.customer_data.ErrorHandlingResponse;
import com.example.cust.customer_data.GetCustomerByIdResponse;
import com.example.cust.customer_model.CustomerModel;
import com.example.cust.customer_repo.CustomerRepo;
import com.example.cust.customer_service.CreateCustomerService;
import com.example.cust.customer_service.GetCustomerService;


@RestController
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CreateCustomerService createCustomerService;

    @Autowired
    private GetCustomerService getCustomerService;

    private final String CUSTOMER_CREATED = "Customer account created";
    private final int CUSTOMER_CREATED_CODE = 201;
    private final String CUSTOMER_NOT_FOUND = "Customer not found.";
    private final int CUSTOMER_NOT_FOUND_CODE = 404;

    @PostMapping("/api/v1/account")
    public ResponseEntity<?> addCustomer(@RequestBody CreateCustomerRequest customer) {
       
        //validate the customer
        CustomerValidation custValidation = new  CustomerValidation();

        ErrorHandlingResponse valRs = custValidation.validate(customer);

        if (null != valRs) {
            return new ResponseEntity<>(valRs, HttpStatus.BAD_REQUEST);
        }

        CustomerModel cust = createCustomerService.createCustomer(customer);

        CreateCustomerResponse response = new CreateCustomerResponse(cust.getCustomerNumber(), CUSTOMER_CREATED_CODE, CUSTOMER_CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping("/api/v1/account/{customerNumber}")
    public ResponseEntity<?> getCustomerByCustomerNumber(@PathVariable Long customerNumber) {
        
        //data may or may not exist
        Optional<CustomerModel> customerData = customerRepo.findById(customerNumber);

        if (customerData.isPresent()) {
            //set the response
         
            GetCustomerByIdResponse response = getCustomerService.getExistingCustomer(customerData.get());
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }

        ErrorHandlingResponse errorResponse = new ErrorHandlingResponse(CUSTOMER_NOT_FOUND_CODE, CUSTOMER_NOT_FOUND);

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }


}
