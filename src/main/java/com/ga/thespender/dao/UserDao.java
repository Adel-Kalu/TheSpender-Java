package com.ga.thespender.dao;

import org.springframework.data.repository.CrudRepository;

import com.ga.thespender.model.User;

public interface UserDao extends CrudRepository<User, Integer> {
	public User findByEmailAddress(String emailAddress);
	public User findById(int id);

}
