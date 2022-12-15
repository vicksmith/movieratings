package com.teksystems.movieratings;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.teksystems.movieratings.database.dao.MovieDAO;
import com.teksystems.movieratings.database.dao.RatingDAO;
import com.teksystems.movieratings.database.entity.Movie;
import com.teksystems.movieratings.database.entity.Rating;

public class MovieDAOTests {

	@Autowired
	private static MovieDAO movieDAO;

	@Autowired
	private RatingDAO ratingDAO;

	@Test
	public void testFindByTitle() {

		String title = "The Shawshank Redemption";
		Movie expected = new Movie();
		expected.setTitle(title);
		expected.setDirector(title);
		expected.setYear(1999);
		expected.setGenre(1);
		expected.setImage("www.yahoo.com");

		List<Map<String, Object>> actual = movieDAO.findByTitle(title);

		Assertions.assertEquals(expected.toString(), actual.toString());
	}

	@ParameterizedTest
	@MethodSource("getByIdTestData")
	public void testGetById(int id, Rating expectedRating) {

		Rating actualRating = ratingDAO.getById(id);

		Assertions.assertEquals(expectedRating, actualRating);

	}
}