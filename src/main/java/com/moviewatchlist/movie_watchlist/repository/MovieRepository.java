package com.moviewatchlist.movie_watchlist.repository;

import com.moviewatchlist.movie_watchlist.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    // Search by title (case insensitive)
    List<Movie> findByTitleContainingIgnoreCase(String title);

    // Filter by genre (case insensitive)
    List<Movie> findByGenreIgnoreCase(String genre);

    // Filter by exact year
    List<Movie> findByYear(Integer year);

    // Filter by rating greater than or equal to a given value
    List<Movie> findByRatingGreaterThanEqual(Double rating);

    // Filter by year range
    @Query("SELECT m FROM Movie m WHERE m.year BETWEEN :startYear AND :endYear")
    List<Movie> findByYearRange(@Param("startYear") Integer startYear, @Param("endYear") Integer endYear);

    // Filter by rating range
    @Query("SELECT m FROM Movie m WHERE m.rating BETWEEN :minRating AND :maxRating")
    List<Movie> findByRatingRange(@Param("minRating") Double minRating, @Param("maxRating") Double maxRating);
}
