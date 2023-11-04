package com.myapi.server.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long customer_id;
  private Long store_id;
  private String first_name;
  private String last_name;
  private String email;
  private Long address_id;
  private Boolean activebool;
  private String create_date;
  private String last_update;
  private Integer active;
 
  public Customer() {

  }

  public Long getCustomer_id() {
    return customer_id;
  }
  public void setCustomer_id(Long customer_id) {
    this.customer_id = customer_id;
  }
  public Long getStore_id() {
    return store_id;
  }
  public void setStore_id(Long store_id) {
    this.store_id = store_id;
  }
  public String getFirst_name() {
    return first_name;
  }
  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }
  public String getLast_name() {
    return last_name;
  }
  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public Long getAddress_id() {
    return address_id;
  }
  public void setAddress_id(Long address_id) {
    this.address_id = address_id;
  }
  public Boolean getActivebool() {
    return activebool;
  }
  public void setActivebool(Boolean activebool) {
    this.activebool = activebool;
  }
  public String getCreate_date() {
    return create_date;
  }
  public void setCreate_date(String create_date) {
    this.create_date = create_date;
  }
  public String getLast_update() {
    return last_update;
  }
  public void setLast_update(String last_update) {
    this.last_update = last_update;
  }
  public Integer getActive() {
    return active;
  }
  public void setActive(Integer active) {
    this.active = active;
  }

  
}
