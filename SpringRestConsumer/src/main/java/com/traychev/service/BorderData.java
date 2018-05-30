package com.traychev.service;

import static javax.persistence.GenerationType.IDENTITY;
import static org.hamcrest.CoreMatchers.instanceOf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author tihom
 *
 */
@Entity
@Table(name = "borderdata")
public class BorderData extends AuditModel {

	/**
	 *
	 */
	private static final long serialVersionUID = 4661187003999874636L;

	@Id
    @GeneratedValue(strategy = IDENTITY)
	private Long id;

	//private List<Crossings> crossings;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "passportid")
	private long passportId;

	@Column(name = "nationality")
	private String nationality;

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof BorderData)) {
			return false;
		}
		BorderData entity = (BorderData) obj;
		return (this.firstName.equals(entity.getFirstName()) && this.lastName.equals(entity.getLastName())
				&& this.nationality.equals(entity.getNationality()) && this.passportId == entity.passportId);
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
