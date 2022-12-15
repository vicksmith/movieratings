package com.teksystems.movieratings.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.movieratings.database.dao.MovieDAO;
import com.teksystems.movieratings.database.entity.Movie;
import com.teksystems.movieratings.form.AddMovieForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
	
	@Autowired
	private MovieDAO movieDAO;

	
	
	
	@GetMapping(value = "/movie/addmovie")
	public ModelAndView addmovie() {
		ModelAndView response = new ModelAndView();
		response.setViewName("addmovie");
		return response;
	}

	@PostMapping(value = "/movie/addmovie")
	public ModelAndView addmovie(@Valid AddMovieForm form, BindingResult bindingResult) {
		ModelAndView response = new ModelAndView();
		response.setViewName("addmovie");
		for (ObjectError e : bindingResult.getAllErrors()) {
			log.debug(e.getObjectName() + " : " + e.getDefaultMessage());

		}
		if (!bindingResult.hasErrors()) {

			Movie movie = new Movie();
			movie.setTitle(form.getTitle());
			movie.setDirector(form.getDirector());
			movie.setYear(form.getYear());
			movie.setGenre(form.getGenre());
			movie.setImage(form.getImage());
			movieDAO.save(movie);
		} else {
			response.addObject("bindingResult", bindingResult);
			response.addObject("form", form);
		}
		return response;

	}

}
