package com.example.exercise_1.controller;

import com.example.exercise_1.model.SoccerPlayer;
import com.example.exercise_1.service.ISoccerPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/soccer-player")
public class SoccerPlayerController {

    @Autowired
    private ISoccerPlayerService iSoccerPlayerService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("list", iSoccerPlayerService.findAll());
        return "/list";
    }

    @GetMapping("/detail/{id}")
    public String detailSoccerPlayer(@PathVariable("id") int id, Model model){
        SoccerPlayer soccerPlayer= iSoccerPlayerService.findById(id);
        model.addAttribute("soccerPlayer", soccerPlayer);
        return "/detail";
    }
    @GetMapping("/delete")
    public String deleteSoccerPlayer(@RequestParam int idDelete){
        iSoccerPlayerService.deleteSoccer(idDelete);
        return "redirect:/soccer-player";
    }
}
