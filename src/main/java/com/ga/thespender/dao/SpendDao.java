package com.ga.thespender.dao;

import org.springframework.data.repository.CrudRepository;

import com.ga.thespender.model.Spend;

public interface SpendDao extends CrudRepository<Spend, Integer> {
	public Spend findById(int id);
}
