package com.moviewatchlist.movie_watchlist.controller;

import com.moviewatchlist.movie_watchlist.model.Movie;
import com.moviewatchlist.movie_watchlist.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Optional<Movie> getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie updatedMovie) {
        return movieService.updateMovie(id, updatedMovie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

    
    @GetMapping("/search")
    public List<Movie> searchMovies(@RequestParam String title) {
        return movieService.searchMovies(title);
    }

    
    @GetMapping("/filter/genre")
    public List<Movie> filterMoviesByGenre(@RequestParam String genre) {
        return movieService.filterMoviesByGenre(genre);
    }

    
    @GetMapping("/filter/year")
    public List<Movie> filterMoviesByYear(@RequestParam Integer year) {
        return movieService.filterMoviesByYear(year);
    }

   
    @GetMapping("/filter/rating")
    public List<Movie> filterMoviesByRating(@RequestParam Double rating) {
        return movieService.filterMoviesByRating(rating);
    }

 
    @GetMapping("/filter/year-range")
    public List<Movie> filterMoviesByYearRange(@RequestParam Integer startYear, @RequestParam Integer endYear) {
        return movieService.filterMoviesByYearRange(startYear, endYear);
    }

   
    @GetMapping("/filter/rating-range")
    public List<Movie> filterMoviesByRatingRange(@RequestParam Double minRating, @RequestParam Double maxRating) {
        return movieService.filterMoviesByRatingRange(minRating, maxRating);
    }
}
