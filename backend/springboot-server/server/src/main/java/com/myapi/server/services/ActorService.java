package com.myapi.server.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapi.server.models.Actor;
import com.myapi.server.repositories.ActorRepository;

@Service
public class ActorService {
  @Autowired
  private ActorRepository actorRepository;

  public List<Actor> getAllActors(){
    return this.actorRepository.findAll();
  }

  public Optional<Actor> getActorById(Long id){
    return this.actorRepository.findById(id);
  }
}
