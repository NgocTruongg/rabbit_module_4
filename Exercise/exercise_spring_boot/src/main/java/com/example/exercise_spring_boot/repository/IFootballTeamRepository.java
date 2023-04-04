package com.example.exercise_spring_boot.repository;

import com.example.exercise_spring_boot.model.FootballTeam;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFootballTeamRepository extends PagingAndSortingRepository<FootballTeam, Integer> {

}
