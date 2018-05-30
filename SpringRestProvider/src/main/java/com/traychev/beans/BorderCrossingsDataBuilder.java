package com.traychev.beans;

import java.util.LinkedList;
import java.util.List;

/**
 * Class to facilitate BorderCrossingsData object creation.
 *
 * @author tihom
 *
 */
public class BorderCrossingsDataBuilder {

	private String firstName;
	private String lastName;
	private long passportId;
	private String nationality;
	private String time;
	private String location;
	private boolean enter;
	List<Crossings> crossings = new LinkedList<Crossings>();

	public BorderCrossingsDataBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public BorderCrossingsDataBuilder setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public BorderCrossingsDataBuilder setPassportId(long passportId) {
		this.passportId = passportId;
		return this;
	}

	public BorderCrossingsDataBuilder setNationality(String nationality) {
		this.nationality = nationality;
		return this;
	}

	public BorderCrossingsDataBuilder setCrossingsData(String time, String location, boolean enter ) {
		Crossings crs = new Crossings(time, location, enter);
		crossings.add(crs);
		return this;
	}

	public BorderCrossingsData build() {
		BorderCrossingsData result = new BorderCrossingsData(firstName, lastName, passportId,
				nationality, crossings.toArray(new Crossings[crossings.size()]));
		return result;
	}
}