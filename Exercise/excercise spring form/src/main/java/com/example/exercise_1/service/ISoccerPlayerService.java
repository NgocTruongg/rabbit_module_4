package com.example.exercise_1.service;

import com.example.exercise_1.model.SoccerPlayer;

import java.util.List;

public interface ISoccerPlayerService {
    List<SoccerPlayer> findAll();
    SoccerPlayer findById(int id);
    void deleteSoccer(int id);

    void create(SoccerPlayer soccerPlayer);

    void update(SoccerPlayer soccerPlayer);

    void save(int id, SoccerPlayer soccerPlayer);
}
