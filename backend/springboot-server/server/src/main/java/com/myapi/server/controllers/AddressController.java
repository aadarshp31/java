package com.myapi.server.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapi.server.models.Address;
import com.myapi.server.services.AddressService;

@RestController
@RequestMapping({ "/api/address", "/api/address/" })
public class AddressController {
  @Autowired
  private AddressService addressService;

  @GetMapping
  public ResponseEntity<Object> getAllAddresses() {
    Map<String, Object> resBody = new HashMap<String, Object>();
    try {
      List<Address> addresses = this.addressService.getAllAddresses();
      resBody.put("status", "success");
      resBody.put("message", "Successfully found all addresses");
      resBody.put("addresses", addresses);
      return new ResponseEntity<Object>(resBody, HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      resBody.put("status", "failure");
      resBody.put("message", String.format("Something went wrong while getting address.\n%s", e.getMessage()));
      return new ResponseEntity<Object>(resBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping({ "/{id}", "/{id}/" })
  public ResponseEntity<Object> getAddressById(@PathVariable Long id) {
    Map<String, Object> resBody = new HashMap<String, Object>();
    try {
      Optional<Address> address = this.addressService.getAddressById(id);
      resBody.put("status", "success");
      resBody.put("message", String.format("Successfully found address with id: %s", id));
      resBody.put("addresses", address.get());
      return new ResponseEntity<Object>(resBody, HttpStatus.OK);

    } catch (NoSuchElementException e) {
      e.printStackTrace();
      resBody.put("status", "failure");
      resBody.put("message", "Address with id: %s does not exists!");
      return new ResponseEntity<Object>(resBody, HttpStatus.NOT_FOUND);

    } catch (Exception e) {
      e.printStackTrace();
      resBody.put("status", "failure");
      resBody.put("message", String.format("Something went wrong while getting address.\n%s", e.getMessage()));
      return new ResponseEntity<Object>(resBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
