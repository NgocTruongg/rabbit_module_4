package com.example.exercise_spring_boot.repository;

import com.example.exercise_spring_boot.model.SoccerPlayer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISoccerPlayerRepository extends PagingAndSortingRepository<SoccerPlayer, Integer> {
    Page<SoccerPlayer> findAllByNameContaining (String name, Pageable pageable);
}
