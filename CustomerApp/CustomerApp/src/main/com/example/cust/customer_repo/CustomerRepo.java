package com.example.cust.customer_repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cust.customer_model.CustomerModel;



@Repository
public interface CustomerRepo extends JpaRepository<CustomerModel, Long> {
//params are the model and the data type of the primary key



}
