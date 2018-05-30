package com.traychev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author tihom
 *
 */
@Service
@Transactional
public class CrossingsService implements ICrossingsService {

	@Autowired
	private CrossingsRepository repository;

	@SuppressWarnings("unused")
	@Autowired
	private BorderDataRepository bdrepository;

	public CrossingsService() {
	}

	@Override
	public List<Crossings> findAll() {
		List<Crossings> crossings = (List<Crossings>) repository.findAll();
		return crossings;
	}

	@Override
	public Crossings save(Crossings entity) {
		return repository.save(entity);
	}

	@Override
	public Iterable<Crossings> saveAll(Iterable<Crossings> crossings) {
		return repository.saveAll(crossings);
	}
}
