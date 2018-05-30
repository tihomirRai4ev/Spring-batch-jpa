package com.traychev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;

import com.traychev.beans.BorderCrossingsData;

/**
 *
 * @author tihom
 *
 */
public interface IBorderDataService {

	public List<BorderData> findAll();

	public Optional<BorderData> findOne(Example<BorderData> example);

	public BorderData save(BorderData entity);

	/**
	 * This method collects records from database and constructs
	 * <b>BorderCrossingsData</b> from it.
	 *
	 * @see com.traychev.beans.BorderCrossingsData
	 *
	 * @return List
	 */
	public List<BorderCrossingsData> fetchBorderCrossingData();

	/**
	 * This method collects records from database only with matching timestamp and
	 * constructs <b>BorderCrossingsData</b> from it.
	 *
	 * @see com.traychev.beans.BorderCrossingsData
	 *
	 * @return List
	 */
	public List<BorderCrossingsData> fetchBorderCrossingData(String timestamp);
}