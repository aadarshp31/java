package com.myapi.server.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Film {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long film_id;
  private String title;
  private String description;
  private Integer release_year;
  private Integer language_id;
  private Integer rental_duration;
  private Integer rental_rate;
  private Integer length;
  private Integer replacement_cost;
  private String rating;
  private String last_update;
  private String[] special_features;
  private String fulltext;

  public Film() {
  }

  // Getters and Setters
  public Long getFilm_id() {
    return film_id;
  }
  public void setFilm_id(Long film_id) {
    this.film_id = film_id;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public Integer getRelease_year() {
    return release_year;
  }
  public void setRelease_year(Integer release_year) {
    this.release_year = release_year;
  }
  public Integer getLanguage_id() {
    return language_id;
  }
  public void setLanguage_id(Integer language_id) {
    this.language_id = language_id;
  }
  public Integer getRental_duration() {
    return rental_duration;
  }
  public void setRental_duration(Integer rental_duration) {
    this.rental_duration = rental_duration;
  }
  public Integer getRental_rate() {
    return rental_rate;
  }
  public void setRental_rate(Integer rental_rate) {
    this.rental_rate = rental_rate;
  }
  public Integer getLength() {
    return length;
  }
  public void setLength(Integer length) {
    this.length = length;
  }
  public Integer getReplacement_cost() {
    return replacement_cost;
  }
  public void setReplacement_cost(Integer replacement_cost) {
    this.replacement_cost = replacement_cost;
  }
  public String getRating() {
    return rating;
  }
  public void setRating(String rating) {
    this.rating = rating;
  }
  public String getLast_update() {
    return last_update;
  }
  public void setLast_update(String last_update) {
    this.last_update = last_update;
  }
  public String[] getSpecial_features() {
    return special_features;
  }
  public void setSpecial_features(String[] special_features) {
    this.special_features = special_features;
  }
  public String getFulltext() {
    return fulltext;
  }
  public void setFulltext(String fulltext) {
    this.fulltext = fulltext;
  }

}
