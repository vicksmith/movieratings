package com.teksystems.movieratings.form;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CreateMovieForm {
	
	private Integer id;
	
	private String director;
	
	private String title;

	private Integer year;
	
	
	private Integer genre;
	

	private String image;

}
