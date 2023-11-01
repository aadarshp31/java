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

import com.myapi.server.models.Film;
import com.myapi.server.services.FilmService;

@RestController
@RequestMapping({ "/api/films", "/api/films/" })
public class FilmController {
  @Autowired
  private FilmService filmService;

  @GetMapping
  public List<Film> getAllFilms() {
    return this.filmService.getAllFilms();
  }

  @GetMapping({ "/{id}", "/{id}/" })
  public ResponseEntity<Object> getFilmById(@PathVariable Long id) {
    Map<String, Object> resBody = new HashMap<String, Object>();
    try {
      Optional<Film> optionalFilm = this.filmService.getFilmById(id);
      List<Film> filmArray = new ArrayList<Film>();
      filmArray.add(optionalFilm.get());
      resBody.put("films", filmArray);
      resBody.put("status", "success");
      resBody.put("message", String.format("Successfully found the film with id: %s", id));
      return new ResponseEntity<Object>(resBody, HttpStatus.OK);

    } catch (NoSuchElementException e) {
      resBody.put("status", "failure");
      resBody.put("message", String.format("The film with id: %s does not exists", id));
      return new ResponseEntity<Object>(resBody, HttpStatus.NOT_FOUND);

    } catch (Exception e) {
      resBody.put("status", "failure");
      resBody.put("message", String.format("Something went wrobg."));
      resBody.put("error", e.getMessage());
      return new ResponseEntity<Object>(resBody, HttpStatus.INTERNAL_SERVER_ERROR);
      
    }
  }
}
