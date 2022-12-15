package com.teksystems.movieratings.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.el.util.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@ControllerAdvice
public class ErrorController {
	
	

	@RequestMapping(value = "/error/404")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String error404(HttpServletRequest request, Exception ex) {

		String origialUri = request.getRequestURI();
		log.error("Requested URL not found : " + request.getMethod() + " " + origialUri);
	

		return "error/404";
	}
	
	
	
	
	
	}
	
	
	

	
