package com.traychev.service;

import java.util.LinkedList;
import java.util.List;

import com.traychev.beans.BorderCrossingsData;
import com.traychev.beans.Crossings;

/**
 *
 * @author tihom
 *
 */
public class Converter {

	private Converter() {
		// Utility class, state not needed.
	}

	/**
	 * This method should convert our POJO fetched from REST API, and convert it to
	 * Crossings entity to facilitate db processing.
	 *
	 * @param data
	 * @return
	 */
	public static Iterable<com.traychev.service.Crossings> convertPojoToEntity(List<BorderCrossingsData> records) {
		List<com.traychev.service.Crossings> result = new LinkedList<com.traychev.service.Crossings>();

		for (BorderCrossingsData record : records) {
			BorderData bEntity = new BorderData();
			bEntity.setFirstName(record.getFirstName());
			bEntity.setLastName(record.getLastName());
			bEntity.setNationality(record.getNationality());
			bEntity.setPassportId(record.getPassportId());
			for (Crossings crossing : record.getCrossings()) {
				com.traychev.service.Crossings crEntity = new com.traychev.service.Crossings();
				crEntity.setBorderData(bEntity);
				crEntity.setEnter(String.valueOf(crossing.isEnter()));
				crEntity.setLocation(crossing.getLocation());
				crEntity.setTime(crossing.getTime());
				/*
				 * the rest fileds in Crossings entity will be filled by Spring aop.
				 */
				result.add(crEntity);
			}
		}
		return result;
	}
}