package com.misaelnt.formula1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.misaelnt.formula1.data.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {    
}
