package com.misaelnt.formula1.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misaelnt.formula1.data.Team;
import com.misaelnt.formula1.repository.TeamRepository;

@RestController
public class TeamController {
    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/teams")
    List<Team> findAll() {
        return teamRepository.findAll();
    }
}
