package com.example.exercise_1.controller;

import com.example.exercise_1.model.SoccerPlayer;
import com.example.exercise_1.service.ISoccerPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/create")
    public String showCreateSoccerPlayer(Model model){
        model.addAttribute("soccerPlayer", new SoccerPlayer());
        return "/create";
    }

    @PostMapping("/create")
    public String createSoccerPlayer(@ModelAttribute SoccerPlayer soccerPlayer){
        iSoccerPlayerService.create(soccerPlayer);
        return "redirect:/soccer-player";
    }

    @GetMapping("/update")
    public String showUpdateSoccerPlayer(@RequestParam int id, Model model) {
        model.addAttribute("soccerPlayer", iSoccerPlayerService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String updateSoccerPlayer(@ModelAttribute SoccerPlayer soccerPlayer) {
        iSoccerPlayerService.update(soccerPlayer);
        return "redirect:/soccer-player";
    }
}
