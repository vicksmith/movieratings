package com.teksystems.movieratings.database.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teksystems.movieratings.database.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long>{


	@Query("SELECT u FROM User u where u.firstName= :firstname")
	public List<User> findByUserFirstName(String firstname);

	public User findByEmail(String email);

	public User findById(Integer id);
}
