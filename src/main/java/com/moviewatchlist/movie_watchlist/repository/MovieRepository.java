package com.moviewatchlist.movie_watchlist.repository;

import com.moviewatchlist.movie_watchlist.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    
    List<Movie> findByTitleContainingIgnoreCase(String title);

    
    List<Movie> findByGenreIgnoreCase(String genre);

    
    List<Movie> findByYear(Integer year);

    
    List<Movie> findByRatingGreaterThanEqual(Double rating);

    
    @Query("SELECT m FROM Movie m WHERE m.year BETWEEN :startYear AND :endYear")
    List<Movie> findByYearRange(@Param("startYear") Integer startYear, @Param("endYear") Integer endYear);

    
    @Query("SELECT m FROM Movie m WHERE m.rating BETWEEN :minRating AND :maxRating")
    List<Movie> findByRatingRange(@Param("minRating") Double minRating, @Param("maxRating") Double maxRating);
}
