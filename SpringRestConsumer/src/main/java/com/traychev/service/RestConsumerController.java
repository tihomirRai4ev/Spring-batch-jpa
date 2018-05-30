package com.traychev.service;

import static com.traychev.service.Converter.convertPojoToEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.traychev.beans.BorderCrossingsData;

@Controller
public class RestConsumerController {

	private final static String API_URL = "http://localhost:8089/data/crossings";

	@Autowired
	private CrossingsService crossingService;

	@Autowired
	private BorderDataService borderDataService;

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * This is only for testing purposes, should not be used. Also in my case db is
	 * getting dropped and re-created every time, this is helper method for testing.
	 *
	 * @throws Exception
	 */
	private void init() throws Exception {
		BorderCrossingsDataReader reader = new BorderCrossingsDataReader(API_URL, restTemplate());
		reader.read();
		Iterable<Crossings> crossingEntities = convertPojoToEntity(reader.readData());
		crossingService.saveAll(crossingEntities);
	}

	@GetMapping("/get/reccords")
	@ResponseBody
	public Iterable<BorderCrossingsData> process(
			@RequestParam(name = "timestamp", required = false, defaultValue = "") String timestamp) throws Exception {
		init(); // THIS IS ONLY TO FILL MY DB FOR TESTING PURPOSES. Comment please.

		if ("".equals(timestamp)) { // Save all new records and return all records from db.
			List<BorderCrossingsData> toJsonOutput = borderDataService.fetchBorderCrossingData();
			return toJsonOutput;
		} else {
			return borderDataService.fetchBorderCrossingData(timestamp);
		}
	}

	@GetMapping("/get/crossings")
	@ResponseBody
	public Iterable<com.traychev.beans.Crossings> getAllCrossingsByPassportId(
			@RequestParam(name = "passportid", required = true) String passportId) throws Exception {
		init(); // THIS IS ONLY TO FILL MY DB FOR TESTING PURPOSES. Comment please.
		return borderDataService.fetchCrossingsByPassportID(passportId);
	}
}