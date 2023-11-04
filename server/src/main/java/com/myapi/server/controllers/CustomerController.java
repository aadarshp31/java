package com.myapi.server.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapi.server.models.Customer;
import com.myapi.server.services.CustomerService;

@RestController
@RequestMapping({ "/api/customers", "/api/customers/" })
public class CustomerController {
  @Autowired
  private CustomerService customerService;

  @GetMapping
  public ResponseEntity<Object> getAllCustomers() {
    Map<String, Object> resBody = new HashMap<String, Object>();
    try {
      List<Customer> customers = this.customerService.getAllCustomers();
      resBody.put("customers", customers);
      resBody.put("status", "success");
      resBody.put("message", String.format("Successfully found the customers"));
      return new ResponseEntity<Object>(resBody, HttpStatus.OK);

    } catch (Exception e) {
      resBody.put("status", "failure");
      resBody.put("message", String.format("Something went wrong while finding customers.\n%s", e.getMessage()));
      return new ResponseEntity<Object>(resBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping({ "/{id}", "/{id}/" })
  public ResponseEntity<Object> getCustomerById(@PathVariable Long id) {
    Map<String, Object> resBody = new HashMap<String, Object>();
    try {
      Optional<Customer> optionalCustomer = this.customerService.getCustomerById(id);
      List<Customer> customers = new ArrayList<Customer>();
      customers.add(optionalCustomer.get());
      resBody.put("customers", customers);
      resBody.put("status", "success");
      resBody.put("message", String.format("Successfully found the customer with id: %s", id));
      return new ResponseEntity<Object>(resBody, HttpStatus.OK);

    } catch (NoSuchElementException e) {
      resBody.put("status", "failure");
      resBody.put("message", String.format("The customer with id: %s does not exists", id));
      return new ResponseEntity<Object>(resBody, HttpStatus.NOT_FOUND);

    } catch (Exception e) {
      resBody.put("status", "failure");
      resBody.put("message", String.format("Something went wrobg."));
      resBody.put("error", e.getMessage());
      return new ResponseEntity<Object>(resBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
