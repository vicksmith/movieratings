package com.teksystems.movieratings.database.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.teksystems.movieratings.database.entity.Rating;

@Repository
public interface RatingDAO extends JpaRepository <Rating, Long> {

	public Rating getById(Integer id);

	@Query("SELECT r FROM Rating r where r.movieId= :id")
	public List<Rating> getByMovieId(Integer id);

	@Query("SELECT r FROM Rating r where r.userId= :id")
	public List<Rating> getbyUserId(Integer id);

    @Query(value="SELECT m.title, r.no_stars, r.comment FROM rating r, movie m where r.movie_id = m.id and r.user_id = :id", nativeQuery=true)
    public List<Map<String, Object>> getUserRatings(@RequestParam("id") Integer id);

}
