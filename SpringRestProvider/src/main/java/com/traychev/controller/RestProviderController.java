package com.traychev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.traychev.beans.BorderCrossingsData;
import com.traychev.beans.BorderCrossingsDataBuilder;

@Controller
public class RestProviderController {
	/**
	 * Request: GET http://{host}/data/crossings/{timestamp}
	 * example:http://norvey.gov.no/data/crossings/1524640959
	 *
	 * Please note the timestamp for this test rest provider will be optional
	 * parameter. If not specified we provide all records.
	 *
	 * @param name
	 * @return
	 */
	@GetMapping("/data/crossings")
	@ResponseBody
	public BorderCrossingsData[] getCrossings(@RequestParam(name = "timestamp", required = false, defaultValue = "") String timestamp) {
		BorderCrossingsData[] data = getSimulatedData();
		//TODO filter for timestamp;
		return data;
	}

	/**
	 * Just simulate several records, no persistence and no resource file, dummy.
	 *
	 * @return
	 */
	private BorderCrossingsData[] getSimulatedData() {

		BorderCrossingsDataBuilder builder1 = new BorderCrossingsDataBuilder();
		builder1.setFirstName("Tihomir");
		builder1.setLastName("Raychev");
		builder1.setCrossingsData("19021991", "New York", true);
		builder1.setCrossingsData("19021945", "Atlanta", true);
		builder1.setCrossingsData("19021994", "California", true);
		builder1.setNationality("Bulgarian");
		builder1.setPassportId(1623774232);
		BorderCrossingsData tihomirData = builder1.build();

		BorderCrossingsDataBuilder builder2 = new BorderCrossingsDataBuilder();
		builder2.setFirstName("test");
		builder2.setLastName("test");
		builder2.setCrossingsData("19021991", "testk", true);
		builder2.setNationality("test");
		builder2.setPassportId(1623773232);
		BorderCrossingsData test1Data = builder2.build();

		BorderCrossingsDataBuilder builder3 = new BorderCrossingsDataBuilder();
		builder3.setFirstName("test2");
		builder3.setLastName("test2");
		builder3.setCrossingsData("234234", "test3", true);
		builder3.setNationality("test2");
		builder3.setPassportId(1623773232);
		BorderCrossingsData test2Data = builder3.build();

		BorderCrossingsData[] result = new BorderCrossingsData[] { tihomirData, test1Data, test2Data };
		return result;
	}
}