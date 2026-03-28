package com.sample.compkey;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class EmployeeIdentity implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long employeeId;
	private Long companyId;

	// Default constructor (required by JPA)
	public EmployeeIdentity() {
	}

	public EmployeeIdentity(Long employeeId, Long companyId) {
		this.employeeId = employeeId;
		this.companyId = companyId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		EmployeeIdentity that = (EmployeeIdentity) o;
		return Objects.equals(employeeId, that.employeeId) && Objects.equals(companyId, that.companyId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId, companyId);
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}