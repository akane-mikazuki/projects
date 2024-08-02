package com.example.cust.customer_repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cust.customer_model.AccountModel;


@Repository
public interface CustomerAccountRepo extends JpaRepository<AccountModel, Long>{

}