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

import com.myapi.server.models.Actor;
import com.myapi.server.services.ActorService;

@RestController
@RequestMapping({ "/api/actors", "/api/actors/" })
public class ActorController {
  @Autowired
  private ActorService actorService;

  @GetMapping
  public ResponseEntity<Object> getAllActors() {
    Map<String, Object> resBody = new HashMap<String, Object>();

    try {
      List<Actor> actors = this.actorService.getAllActors();
      resBody.put("actors", actors);
      resBody.put("status", "success");
      resBody.put("message", "Successfully found actors");
      return new ResponseEntity<Object>(resBody, HttpStatus.OK);

    } catch (Exception e) {
      resBody.put("status", "failure");
      resBody.put("message", "Something went wrong while finding actors.");
      return new ResponseEntity<Object>(resBody, HttpStatus.OK);
    }
  }

  @GetMapping({ "/{id}", "/{id}/" })
  public ResponseEntity<Object> getActorById(@PathVariable Long id) {
    Map<String, Object> resBody = new HashMap<String, Object>();

    try {
      Optional<Actor> actor = this.actorService.getActorById(id);
      resBody.put("status", "success");
      resBody.put("message", String.format("Successfully found actor with id: %s", id));
      resBody.put("actors", actor.get());
      return new ResponseEntity<Object>(resBody, HttpStatus.OK);

    } catch (NoSuchElementException e) {
      resBody.put("status", "failure");
      resBody.put("message", String.format("Failed to find the actor with id: %s", id));
      return new ResponseEntity<Object>(resBody, HttpStatus.NOT_FOUND);

    } catch (Exception e) {
      e.printStackTrace();
      resBody.put("status", "failure");
      resBody.put("message", "Something went wrong");
      return new ResponseEntity<Object>(resBody, HttpStatus.INTERNAL_SERVER_ERROR);

    }
  }
}
