package com.example.exercise_spring_boot.service;

import com.example.exercise_spring_boot.model.FootballTeam;

import java.util.List;

public interface IFootballTeamService {
    List<FootballTeam> findAll();
}
