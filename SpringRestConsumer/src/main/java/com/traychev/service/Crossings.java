package com.traychev.service;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author tihom
 *
 */
@Entity
@Table(name = "crossings")
public class Crossings extends AuditModel {

	/**
	 *
	 */
	private static final long serialVersionUID = 5911411664733976080L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "time")
	private String time;

	@Column(name = "location")
	private String location;

	@Column(name = "enter")
	private String enter;

	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "crossings_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private BorderData borderData;

	public String getTime() {
		return time;
	}

	public void setTime(String text) {
		this.time = text;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEnter() {
		return enter;
	}

	public void setEnter(String enter) {
		this.enter = enter;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BorderData getBorderData() {
		return borderData;
	}

	public void setBorderData(BorderData borderData) {
		this.borderData = borderData;
	}

	@Override
	public String toString() {
		return time + " " + location + " " + enter;
	}
}