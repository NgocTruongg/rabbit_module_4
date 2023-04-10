package com.example.exercise_spring_boot.controller;

import com.example.exercise_spring_boot.model.SoccerPlayer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class SoccerPlayerFavoritesController {

    @GetMapping("/favorites")
    public String getFavoritesRoom(@SessionAttribute("soccerPlayerFavorites")List<SoccerPlayer> soccerPlayerList,
                                   Model model){
        model.addAttribute("SoccerPlayerFavorites", soccerPlayerList);
        return "player_favorites";
    }
}
