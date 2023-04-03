package com.example.exercise_spring_boot.service;

import com.example.exercise_spring_boot.model.SoccerPlayer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISoccerPlayerService {
    Page<SoccerPlayer> findAll(String name, Pageable pageable);
    SoccerPlayer findById(int id);
    void deleteSoccer(int id);

    void create(SoccerPlayer soccerPlayer);

    void update(SoccerPlayer soccerPlayer);


}
