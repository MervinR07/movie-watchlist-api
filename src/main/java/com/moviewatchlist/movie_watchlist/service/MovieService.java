package com.moviewatchlist.movie_watchlist.service;

import com.moviewatchlist.movie_watchlist.model.Movie;
import com.moviewatchlist.movie_watchlist.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie updatedMovie) {
        Optional<Movie> existingMovie = movieRepository.findById(id);
        if (existingMovie.isPresent()) {
            Movie movie = existingMovie.get();
            movie.setTitle(updatedMovie.getTitle());
            movie.setGenre(updatedMovie.getGenre());
            movie.setYear(updatedMovie.getYear());
            movie.setRating(updatedMovie.getRating());
            return movieRepository.save(movie);
        }
        return null;
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    // ✅ Search movies by title
    public List<Movie> searchMovies(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    // ✅ Filter movies by genre
    public List<Movie> filterMoviesByGenre(String genre) {
        return movieRepository.findByGenreIgnoreCase(genre);
    }

    // ✅ Filter movies by exact year
    public List<Movie> filterMoviesByYear(Integer year) {
        return movieRepository.findByYear(year);
    }

    // ✅ Filter movies by rating greater than or equal to a given value
    public List<Movie> filterMoviesByRating(Double rating) {
        return movieRepository.findByRatingGreaterThanEqual(rating);
    }

    // ✅ Filter movies by a range of years
    public List<Movie> filterMoviesByYearRange(Integer startYear, Integer endYear) {
        return movieRepository.findByYearRange(startYear, endYear);
    }

    // ✅ Filter movies by a range of ratings
    public List<Movie> filterMoviesByRatingRange(Double minRating, Double maxRating) {
        return movieRepository.findByRatingRange(minRating, maxRating);
    }
}
