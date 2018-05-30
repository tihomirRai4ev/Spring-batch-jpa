package com.traychev.beans;

import java.util.List;

/**
 * Bean class to implement the following JSON format:
 *
 * [{ "firstName": string, "lastName": sting, "passportId": long, "nationality":
 * string, "crossings": [{"time": timestampSeconds, "location": string, "enter":
 * boolean}] }]
 *
 * @author tihom
 *
 */
public class BorderCrossingsData {

	private String firstName;
	private String lastName;
	private long passportId;
	private String nationality;
	Crossings[] crossings;

	public BorderCrossingsData() {
	}; // Needed by spring.

	BorderCrossingsData(String firsName, String lastName, long passportId, String nationality, Crossings[] crossings) {
		this.firstName = firsName;
		this.lastName = lastName;
		this.passportId = passportId;
		this.nationality = nationality;
		this.crossings = crossings;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPassportId() {
		return passportId;
	}

	public void setPassportId(long passportId) {
		this.passportId = passportId;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Crossings[] getCrossings() {
		return crossings;
	}

	public void setCrossings(Crossings[] crossings) {
		this.crossings = crossings;
	}

	public void setCrossingsFromList(List<Crossings> crossings) {
		this.crossings = new Crossings[crossings.size()];
		for (int i = 0; i < crossings.size(); i++) {
			this.crossings[i] = crossings.get(i);
		}
	}
}
