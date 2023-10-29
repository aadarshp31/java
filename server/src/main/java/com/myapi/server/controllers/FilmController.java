package com.myapi.server.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapi.server.models.Film;
import com.myapi.server.services.FilmService;

@RestController
@RequestMapping("/api/films")
public class FilmController {
  private final FilmService filmService;

  // constructor
  public FilmController(FilmService filmService) {
    this.filmService = filmService;
  }

  @GetMapping
  public List<Film> getAllFilms(){
    return this.filmService.getAllFilms();
  }
  
}
