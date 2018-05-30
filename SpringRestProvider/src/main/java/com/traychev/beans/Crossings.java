package com.traychev.beans;

/**
 * Bean to implement the following JSON mapping:
 *
 * "crossings": [{"time": timestampSeconds, "location": string, "enter":
 * boolean}]
 *
 * @author tihom
 *
 */
public class Crossings {

	private String time;
	private String location;
	private boolean enter;

	public Crossings(){}; // needed for spring
	
	Crossings(String time, String location, boolean enter) {
		this.time = time;
		this.location = location;
		this.enter = enter;
	}

	public boolean equals(Crossings crs) {
		return (this.time.equals(crs.time)
				&& this.location.equals(crs.location)
				&& this.enter == crs.enter);
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isEnter() {
		return enter;
	}

	public void setEnter(boolean enter) {
		this.enter = enter;
	}
}