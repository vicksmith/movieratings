package com.teksystems.movieratings.database.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teksystems.movieratings.database.entity.UserRole;

@Repository
public interface UserRoleDAO extends JpaRepository<UserRole, Long>{

	public List<UserRole> findByUserId(Integer userId);

}
