package com.example.exercise_1.service.Impl;

import com.example.exercise_1.model.SoccerPlayer;
import com.example.exercise_1.repository.ISoccerPlayerRepository;
import com.example.exercise_1.service.ISoccerPlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SoccerPlayerService implements ISoccerPlayerService {

    @Autowired
    private ISoccerPlayerRepository soccerPlayerRepository;

    @Override
    public List<SoccerPlayer> findAll() {
       return soccerPlayerRepository.findAll();
    }

    @Override
    public SoccerPlayer findById(int id) {
        return soccerPlayerRepository.findById(id);
    }

    @Override
    public void deleteSoccer(int id) {
        soccerPlayerRepository.deleteSoccer(id);
    }
}
