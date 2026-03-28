package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.model.DemoUser;

@Repository
public interface UserRepository extends JpaRepository<DemoUser, Long> {
	
}