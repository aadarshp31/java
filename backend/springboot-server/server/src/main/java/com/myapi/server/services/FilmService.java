package com.myapi.server.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapi.server.models.Film;
import com.myapi.server.repositories.FilmRepository;

@Service
public class FilmService {
  @Autowired
  private FilmRepository filmRepository;

  public List<Film> getAllFilms(){
    return this.filmRepository.findAll();
  }

  public Optional<Film> getFilmById(Long id){
    return this.filmRepository.findById(id);
  }
}
