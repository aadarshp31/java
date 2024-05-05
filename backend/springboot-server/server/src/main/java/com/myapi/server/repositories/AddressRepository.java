package com.myapi.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapi.server.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
