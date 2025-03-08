package com.moviewatchlist.movie_watchlist.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre;
    private int year;

    @JsonInclude(JsonInclude.Include.NON_NULL) // Ignore null values in JSON response
    private Double rating;

    // Default constructor
    public Movie() {}

    // Constructor with parameters
    public Movie(String title, String genre, int year, Double rating) { // Changed 'double' to 'Double'
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public Double getRating() { return rating; }  // Changed return type to Double
    public void setRating(Double rating) { this.rating = rating; } // Changed param type to Double
}
