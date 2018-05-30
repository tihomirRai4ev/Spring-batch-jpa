package com.traychev.service;

import java.util.List;

/**
 * 
 * @author tihom
 *
 */
public interface ICrossingsService {

	public List<Crossings> findAll();

	public Crossings save(Crossings entity);

	public Iterable<Crossings> saveAll(Iterable<Crossings> crossings);

}
