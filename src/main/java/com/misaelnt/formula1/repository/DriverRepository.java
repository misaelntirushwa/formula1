package com.misaelnt.formula1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.misaelnt.formula1.data.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {    
}
