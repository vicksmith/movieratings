package com.teksystems.movieratings.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.movieratings.database.dao.MovieDAO;
import com.teksystems.movieratings.database.dao.RatingDAO;
import com.teksystems.movieratings.database.dao.UserDAO;
import com.teksystems.movieratings.database.entity.Movie;
import com.teksystems.movieratings.database.entity.Rating;
import com.teksystems.movieratings.database.entity.User;
import com.teksystems.movieratings.security.AuthenticatedUserService;

@Controller
public class IndexController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private MovieDAO movieDAO;

	@Autowired
	private RatingDAO ratingDAO;

	@Autowired
	private AuthenticatedUserService authenticatedUserService;

	@RequestMapping(value = { "/", "/index", "/index.html" }, method = RequestMethod.GET)
	public ModelAndView slash() {
		ModelAndView response = new ModelAndView();
		response.setViewName("index");
		List<Map<String, Object>> movies = movieDAO.findMovieDetails();
		response.addObject("movies", movies);
		return response;

	}

//	@GetMapping(value="/movie")
//	public ModelAndView movie() {
//		ModelAndView response = new ModelAndView();
//		response.setViewName("movie");
//		return response;

//	}
	@GetMapping(value = "/search")
	public ModelAndView search(@RequestParam String search) {
		ModelAndView response = new ModelAndView();
		response.setViewName("index");
		List<Movie> movies = movieDAO.findByTitle(search);
		response.addObject("movies", movies);
		return response;

	}

	@GetMapping(value = "/moviedetails")
	public ModelAndView search(@RequestParam Integer id) {
		ModelAndView response = new ModelAndView();
		response.setViewName("moviedetails");
		Map<String, Object>movie=movieDAO.findMovieDetails(id);
		List<Rating> ratings = ratingDAO.getByMovieId(id);
		response.addObject("movie", movie);
		response.addObject("ratings", ratings);
		return response;

	}
	@PostMapping(value = "/movie/rating")
	public ModelAndView rating(@RequestParam Integer stars,@RequestParam String comment,@RequestParam Integer movieId) {
		ModelAndView response = new ModelAndView();
		response.setViewName("redirect:/moviedetails?id="+movieId);

		User user= authenticatedUserService.getCurrentUser();
		Rating rating = new Rating();
		rating.setUserId(user.getId());
		rating.setNoStars(stars);
		rating.setComment(comment);
		rating.setMovieId(movieId);
		ratingDAO.save(rating);


		return response;
}
	@GetMapping(value = "/userprofile")
	public ModelAndView userprofile() {
		ModelAndView response = new ModelAndView();
		User user = authenticatedUserService.getCurrentUser();
		response.addObject("user", user);
		response.setViewName("userprofile");
		List<Map<String, Object>> ratings = ratingDAO.getUserRatings(user.getId());
        response.addObject("ratings", ratings);
        
		return response;
	}
}