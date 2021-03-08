package com.ga.thespender.dao;

import org.springframework.data.repository.CrudRepository;

import com.ga.thespender.model.SpendTo;

public interface SpendToDao extends CrudRepository<SpendTo, Integer> {
	public SpendTo findById(int id);
}
