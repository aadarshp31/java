package com.myapi.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapi.server.models.Customer;

@Repository 
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  
}
