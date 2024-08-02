package com.example.cust;

import com.example.cust.customer_data.CreateCustomerRequest;

//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;

import com.example.cust.customer_data.ErrorHandlingResponse;

public class CustomerValidation {

    public ErrorHandlingResponse validate (CreateCustomerRequest customerModel) {

        //validate customerName
        if (customerModel.getCustomerName().length() > 50) {
            ErrorHandlingResponse response = 
          new ErrorHandlingResponse( 400, "The length of the customer name must only be up to 50 characters.");
          return response; 
        }

        if (null == customerModel.getCustomerName() || customerModel.getCustomerName().isEmpty()) {
            ErrorHandlingResponse response = 
            new ErrorHandlingResponse( 400, "The customer name is a required field.");
            return response; 
        }

        //validate mobile number
        if (customerModel.getCustomerMobile().length() > 20) {
            ErrorHandlingResponse response = 
            new ErrorHandlingResponse(400, "The length of the mobile number must only be up to 50 characters.");
            return response; 
        }

        if (null == customerModel.getCustomerMobile() || customerModel.getCustomerMobile().isEmpty()) {
            ErrorHandlingResponse response = 
            new ErrorHandlingResponse(400, "The mobile number is a required field.");
            return response; 
        }

        //validate email
        if (customerModel.getCustomerEmail().length() > 50) {
            ErrorHandlingResponse response = 
            new ErrorHandlingResponse(400, "The length of the email must only be up to 50 characters.");
            return response; 
        }

        if (null == customerModel.getCustomerEmail() || customerModel.getCustomerEmail().isEmpty()) {
            ErrorHandlingResponse response = 
            new ErrorHandlingResponse( 400, "Email is a required field.");
            return response; 
        }

        //validate Address1
        if (customerModel.getAddress1().length() > 100) {
            ErrorHandlingResponse response = 
            new ErrorHandlingResponse(400, "The length of the Address1 must only be up to 100 characters.");
            return response; 
        }

        if (null == customerModel.getAddress1() || customerModel.getAddress1().isEmpty()) {
            ErrorHandlingResponse response = 
            new ErrorHandlingResponse(400, "The Address1 is a required field.");
            return response; 
        }

        //validate Address2
        if (customerModel.getAddress2().length() > 100) {
            ErrorHandlingResponse response = 
            new ErrorHandlingResponse( 400, "The length of the Address2 must only be up to 100 characters.");
            return response; 
        }

        if (null == customerModel.getAddress2() || customerModel.getAddress2().isEmpty()) {
            ErrorHandlingResponse response = 
            new ErrorHandlingResponse( 400, "The Address2 is a required field.");
            return response; 
        }

        return null;
    }

}
