package com.traychev.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.traychev.beans.BorderCrossingsData;

/**
 * Creating an ItemReader That Reads Input Data From a REST API.
 *
 * @author tihom
 *
 */
public class BorderCrossingsDataReader implements ItemReader<BorderCrossingsData> {

	private final String apiUrl;
	private final RestTemplate restTemplate;

	private int nextDataIndex;
	private List<BorderCrossingsData> data;

	public BorderCrossingsDataReader(String apiUrl, RestTemplate restTemplate) {
		this.apiUrl = apiUrl;
		this.restTemplate = restTemplate;
		nextDataIndex = 0;
	}

	public List<BorderCrossingsData> readData() {
		return this.data;
	}

	@Override
	public BorderCrossingsData read() throws Exception {
		if (dataIsNotInitialized()) {
			data = fetchCrossingsDataFromAPI();
		}

		BorderCrossingsData nextRecord = null;

		if (nextDataIndex < data.size()) {
			nextRecord = data.get(nextDataIndex);
			++nextDataIndex;
		}

		return nextRecord;
	}

	private boolean dataIsNotInitialized() {
		return this.data == null;
	}

	private List<BorderCrossingsData> fetchCrossingsDataFromAPI() {
		ResponseEntity<BorderCrossingsData[]> response = restTemplate.getForEntity(apiUrl, BorderCrossingsData[].class);
		BorderCrossingsData[] data = response.getBody();
		return Arrays.asList(data);
	}
}