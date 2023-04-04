package com.example.exercise_spring_boot.service.impl;

import com.example.exercise_spring_boot.model.FootballTeam;
import com.example.exercise_spring_boot.repository.IFootballTeamRepository;
import com.example.exercise_spring_boot.service.IFootballTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootballTeamService implements IFootballTeamService {
    @Autowired
    private IFootballTeamRepository iFootballTeamRepository;

    @Override
    public List<FootballTeam> findAll() {
        return (List<FootballTeam>) iFootballTeamRepository.findAll();
    }
}
