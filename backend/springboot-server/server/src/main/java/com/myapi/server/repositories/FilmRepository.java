package com.myapi.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapi.server.models.Film;

@Repository 
public interface FilmRepository extends JpaRepository<Film, Long> {
  
}
