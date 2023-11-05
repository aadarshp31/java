package com.myapi.server.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Actor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long actor_id;
  private String first_name;
  private String last_name;
  private String last_update;

  public Actor() {
  }

  public Long getActor_id() {
    return actor_id;
  }

  public void setActor_id(Long actor_id) {
    this.actor_id = actor_id;
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

  public String getLast_update() {
    return last_update;
  }

  public void setLast_update(String last_update) {
    this.last_update = last_update;
  }

}
