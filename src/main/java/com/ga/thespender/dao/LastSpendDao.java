package com.ga.thespender.dao;

import org.springframework.data.repository.CrudRepository;

import com.ga.thespender.model.LastSpend;

public interface LastSpendDao extends CrudRepository<LastSpend, Integer> {
	public LastSpend findById(int id);
}
