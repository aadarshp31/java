package com.myapi.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapi.server.models.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {
  
}
