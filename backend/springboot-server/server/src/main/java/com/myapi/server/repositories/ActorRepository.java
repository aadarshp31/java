package com.myapi.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapi.server.models.Actor;


public interface ActorRepository extends JpaRepository<Actor, Long>{
  
}
