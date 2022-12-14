package com.teksystems.movieratings.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class AddMovieForm {
	
	@NotEmpty(message = "Title is required.")
	@Length(max=45, message= "Title must be 45 characters or less.")
	private String title;
	
	@NotEmpty(message = "Director is required.")
	@Length(max=45, message= "Director must be 45 characters or less.")
	private String director;
	
	@NotEmpty(message = "Year is required.")
	private Integer year;
	
	@NotEmpty(message = "Genre is required.")
	private Integer genre;
	
	@Length(max=200, message= "Image url must be 200 characters or less.")
	private String image;
	

}
