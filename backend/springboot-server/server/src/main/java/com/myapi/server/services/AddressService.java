package com.myapi.server.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapi.server.models.Address;
import com.myapi.server.repositories.AddressRepository;

@Service
public class AddressService {
  @Autowired
  private AddressRepository addressRepository;

  public List<Address> getAllAddresses() {
    return this.addressRepository.findAll();
  }

  public Optional<Address> getAddressById(Long id) {
    return this.addressRepository.findById(id);
  }
  
}
