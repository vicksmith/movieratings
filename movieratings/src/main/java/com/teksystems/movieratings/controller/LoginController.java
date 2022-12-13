package com.teksystems.movieratings.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.movieratings.database.dao.UserDAO;
import com.teksystems.movieratings.database.entity.User;
import com.teksystems.movieratings.form.CreateUserForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	@Autowired
	private UserDAO userDao;

	@GetMapping(value = "/user/login")
	public ModelAndView login() {
		ModelAndView response = new ModelAndView();
		response.setViewName("login");
		return response;
	}

	@GetMapping(value = "/user/createuser")
	public ModelAndView createuser() {
		ModelAndView response = new ModelAndView();
		response.setViewName("createuser");


		return response;
	}
	@PostMapping(value = "/user/createuser")
	public ModelAndView createUserSubmit(@Valid CreateUserForm form, BindingResult bindingResult) {
		ModelAndView response = new ModelAndView();
		response.setViewName("createuser");
		log.debug("This is in the POST method for create user");

		log.debug(form.toString());



			User user = new User();

			user.setFirstName(form.getFirstName());
			user.setLastName(form.getLastName());
			user.setPassword(form.getPassword());
			user.setEmail(form.getEmail());


			user.setAvatar(form.getAvatar());
			userDao.save(user);







		return response;
	}


}
