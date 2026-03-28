package com.sample.compkey;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class EmployeeEmbeddedKeySample {

	@EmbeddedId
	private EmployeeIdentity id;

	private String name;

	public EmployeeIdentity getId() {
		return id;
	}

	public void setId(EmployeeIdentity id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
