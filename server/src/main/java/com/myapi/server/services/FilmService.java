package com.myapi.server.services;

import java.util.List;

import com.myapi.server.models.Film;
import com.myapi.server.repositories.FilmRepository;


public class FilmService {
  private FilmRepository filmRepository;

  public FilmService(FilmRepository filmRepository) {
    this.filmRepository = filmRepository;
  }

  public List<Film> getAllFilms(){
    return this.filmRepository.findAll();
  }
}
