package com.example.cust;

import javax.persistence.*;

import com.example.cust.customer_data.CreateCustomerRequest;



@Converter(autoApply = true)
public class AccountTypeConverter implements AttributeConverter<CreateCustomerRequest.AccountType, String> {

    @Override
    public String convertToDatabaseColumn(CreateCustomerRequest.AccountType accountType) {
        return accountType != null ? accountType.getCode() : null;
    }

    @Override
    public CreateCustomerRequest.AccountType convertToEntityAttribute(String dbData) {
        return dbData != null ? CreateCustomerRequest.AccountType.fromCode(dbData) : null;
    }

}