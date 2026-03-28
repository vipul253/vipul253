package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.compkey.EmployeeIdClassSample;
import com.sample.compkey.EmployeeIdentity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeIdClassSample, EmployeeIdentity> {
	// can also use EmployeeEmbeddedKeySample instead of EmployeeIdClassSample.
	// Custom finder methods can use properties from the composite key class
	// For example, findByIdEmployeeIdAndIdCompanyId(...) is implicitly supported.
}
