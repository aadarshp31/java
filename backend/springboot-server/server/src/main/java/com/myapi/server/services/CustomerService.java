package com.myapi.server.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapi.server.models.Customer;
import com.myapi.server.repositories.CustomerRepository;

@Service
public class CustomerService {
  @Autowired
  private CustomerRepository customerRepository;

  public List<Customer> getAllCustomers(){
    return this.customerRepository.findAll();
  }

  public Optional<Customer> getCustomerById(Long id){
    return this.customerRepository.findById(id);
  }
}
