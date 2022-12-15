package com.teksystems.movieratings.database.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.teksystems.movieratings.database.entity.Movie;

@Repository
public interface MovieDAO extends JpaRepository<Movie, Long> {

	@Query(value="SELECT m.id, m.image, m.title, m.director, m.year, g.name from movie m join genre g where m.title =:title",nativeQuery = true)
	public List<Map<String, Object>>findByTitle(String title );

	public Movie getById(Integer id);
	
	@Query(value="SELECT m.id, m.image, m.title, m.director, m.year, g.name from movie m join genre g where m.genre = g.id",nativeQuery=true)
	public List<Map<String, Object>> findMovieDetails();
	
	@Query(value="SELECT m.id, m.image, m.title, m.director, m.year, g.name from movie m join genre g where m.genre = g.id and m.id = :id",nativeQuery=true)
	public Map<String, Object> findMovieDetails(Integer id);

	}
