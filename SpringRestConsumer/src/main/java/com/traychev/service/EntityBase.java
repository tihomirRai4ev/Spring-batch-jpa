package com.traychev.service;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntityBase {
	@Id
	@GeneratedValue
	private int id;
}
