package com.example.exercise_spring_boot.service.impl;

import com.example.exercise_spring_boot.dto.SoccerPlayerDTO;
import com.example.exercise_spring_boot.model.SoccerPlayer;
import com.example.exercise_spring_boot.repository.ISoccerPlayerRepository;
import com.example.exercise_spring_boot.service.ISoccerPlayerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SoccerPlayerService implements ISoccerPlayerService {

    @Autowired
    private ISoccerPlayerRepository iSoccerPlayerRepository;


    @Override
    public Page<SoccerPlayer> findAll(String name, Pageable pageable) {
        return iSoccerPlayerRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public SoccerPlayer findById(int id) {
        return iSoccerPlayerRepository.findById(id).get();
    }

    @Override
    public void deleteSoccer(int id) {
        iSoccerPlayerRepository.delete(findById(id));
    }

    @Override
    public void create(SoccerPlayerDTO soccerPlayerDTO) {
        SoccerPlayer soccerPlayer = new SoccerPlayer();
        BeanUtils.copyProperties(soccerPlayerDTO, soccerPlayer);
        iSoccerPlayerRepository.save(soccerPlayer);
    }

    @Override
    public void update(SoccerPlayer soccerPlayer) {
        iSoccerPlayerRepository.save(soccerPlayer);
    }

    @Override
    public void register(SoccerPlayer soccerPlayer) {
        List<SoccerPlayer> soccerPlayerList = iSoccerPlayerRepository.findAll();
        List<SoccerPlayer> registeredList = new ArrayList<>();
        for (int i = 0; i < soccerPlayerList.size(); i++) {
            if (soccerPlayerList.get(i).getStatus() == "Đã đăng kí") {
                registeredList.add(soccerPlayerList.get(i));
            }
        }
        if (registeredList.size() <= 11) {
            for (int i = 0; i < soccerPlayerList.size(); i++) {
                if (soccerPlayerList.get(i).getId() == soccerPlayer.getId()) {
                    soccerPlayerList.get(i).setStatus("Đã đăng kí");
                    iSoccerPlayerRepository.save(soccerPlayerList.get(i));
                }
            }
        }
    }

    @Override
    public List<SoccerPlayer> footballTeam() {
        return iSoccerPlayerRepository.findAllByStatus();
    }

}
