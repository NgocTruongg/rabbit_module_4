package com.example.exercise_spring_boot.controller;

import com.example.exercise_spring_boot.model.SoccerPlayer;
import com.example.exercise_spring_boot.service.ISoccerPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/soccer-player")
public class SoccerPlayerController {

    @Autowired
    private ISoccerPlayerService iSoccerPlayerService;

    @GetMapping("")
    public String showList(Model model, @RequestParam(defaultValue = "", required = false) String name, Integer page,
                           @PageableDefault(size = 3) Pageable pageable) {
        if (name == null) {
            name = "";
        }
        if (page == null) {
            page = 0;
        }
        Sort sort = null;
        if (name == name) {
             sort = Sort.by("dateOfBirth").ascending();
        } else {
             sort = Sort.by("name").ascending();
        }
        Pageable sortPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),sort );
        Page<SoccerPlayer> soccerPlayerPage = iSoccerPlayerService.findAll(name, sortPageable);
        model.addAttribute("soccerPlayerList", soccerPlayerPage);
        model.addAttribute("name", name);
        List<Integer> pageNumberList = new ArrayList<>();
        for (int i = 1; i <= soccerPlayerPage.getTotalPages(); i++) {
            pageNumberList.add(i);
        }

        for (int i = 1; i <= pageNumberList.size() ; i++) {
            if (i == page){
                model.addAttribute("page", i-1);
            }
        }
        model.addAttribute("pageNumberList", pageNumberList);
        return "/list";
    }

    @GetMapping("/detail/{id}")
    public String detailSoccerPlayer(@PathVariable("id") int id, Model model) {
        SoccerPlayer soccerPlayer = iSoccerPlayerService.findById(id);
        model.addAttribute("soccerPlayer", soccerPlayer);
        return "/detail";
    }

    @GetMapping("/delete")
    public String deleteSoccerPlayer(@RequestParam int idDelete) {
        iSoccerPlayerService.deleteSoccer(idDelete);
        return "redirect:/soccer-player";
    }

    @GetMapping("/create")
    public String showCreateSoccerPlayer(Model model) {
        model.addAttribute("soccerPlayer", new SoccerPlayer());
        return "/create";
    }

    @PostMapping("/create")
    public String createSoccerPlayer(@ModelAttribute SoccerPlayer soccerPlayer) {
        iSoccerPlayerService.create(soccerPlayer);
        return "redirect:/soccer-player";
    }

    @GetMapping("/update")
    public String showUpdateSoccerPlayer(@RequestParam(required = false) int id, Model model, String name,
                                         @PageableDefault Pageable pageable) {
        model.addAttribute("soccerPlayerList", iSoccerPlayerService.findAll(name, pageable));
        model.addAttribute("soccerPlayer", iSoccerPlayerService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String updateSoccerPlayer(@ModelAttribute SoccerPlayer soccerPlayer) {
        iSoccerPlayerService.update(soccerPlayer);
        return "redirect:/soccer-player";
    }
}
