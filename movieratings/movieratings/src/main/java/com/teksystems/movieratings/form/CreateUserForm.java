package com.teksystems.movieratings.form;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CreateUserForm {


	@NotEmpty(message = "Email is required.")
	@Length(max = 200, message = "Email must be less than 200 characters.")
	private String email;

	private String password;
	private String confirmPassword;
	private String firstName;
	private String lastName;
	private String avatar;


}
