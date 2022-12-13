package com.teksystems.movieratings.database.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movie")
@Entity
public class Movie {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="director")
	private String director;
	@Column(name="title")
	private String title;
	@Column(name="year")
	private Integer year;
	
	@Column(name="genre")
	private Integer genre;
	
	@Column(name="image")
	private String image;

}
