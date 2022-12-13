package com.teksystems.movieratings.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

	@Configuration
	@EnableWebSecurity
	@EnableGlobalMethodSecurity(prePostEnabled=true)
	public class SecurityConfig extends WebSecurityConfigurerAdapter{

		@Override
		protected void configure(final HttpSecurity http) throws Exception {
			http
				.csrf().disable()
		        .authorizeRequests()
		        	// this line of code specifies all URLs that do not need authentication to view
		        	// this is the most important line to pay attention to.  If you want to make another URL
		        	// open to the public then you have to come back here and add it.
		        	.antMatchers("/pub/**","/user/**", "/", "/index","/moviedetails/**", "/search", "/course/**", "/error/**").permitAll()
		        	// this line of code tells spring security that all URLs can only be accessed if the user
		        	// is authenticated.   This is authetnication only and does not care about authorization.
		        	// authorization must be implement in the controller to limit by user role
		        	// this has the effect of making all requests require authentication which is a deisgn pattern
		        	// once all is security then we provided excpeptions using permitAll
					.anyRequest().authenticated()
		        	.and()
		        .formLogin()
		        	// this is the URL to the login page
		        	// the request method for this is implemented in the login controller
		        	// to display the login.jsp view
		            .loginPage("/user/login")
		            // this is the URL that the login page will submit to with a action="/user/loginpost" method="POST"
		            // this controller method is implemented by spring security and you dont have to do anything to use it
		            // other than set the method to post and set the action to this URL
		            .loginProcessingUrl("/user/loginpost")
		            // this URL is where spring security will send the user IF they have not requested a secure URL
		            // if they have requested a secure URL spring security will ignore this and send them to the
		            // secured url they requested
		            .defaultSuccessUrl("/")
		            .and()
		        .logout()
		            .invalidateHttpSession(true)
		            // this is the URL to log a user out
		            .logoutUrl("/user/logout")
		            // this is the URL to send the browser to after the user has logged out
		            .logoutSuccessUrl("/index");


		}



		// this is boiler plate code that can be copied and pasted into your security configuration
		@Bean(name="passwordEncoder")
		public PasswordEncoder getPasswordEncoder() {
			return new BCryptPasswordEncoder();
		}

	}

