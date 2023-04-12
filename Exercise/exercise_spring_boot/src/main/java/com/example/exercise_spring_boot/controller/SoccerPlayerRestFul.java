package com.example.exercise_spring_boot.controller;

import com.example.exercise_spring_boot.dto.SoccerPlayerDTO;
import com.example.exercise_spring_boot.model.SoccerPlayer;
import com.example.exercise_spring_boot.service.ISoccerPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/soccer-player")
@CrossOrigin("*")
public class SoccerPlayerRestFul {
    @Autowired
    private ISoccerPlayerService iSoccerPlayerService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Page<SoccerPlayer> getList(@Valid @RequestParam(name = "name", defaultValue = "", required = false)
                                      @PageableDefault(size = 3) String name, Pageable pageable) {
        return iSoccerPlayerService.findAll(name, pageable);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createSoccer(@RequestBody SoccerPlayerDTO soccerPlayerDTO) {
        iSoccerPlayerService.create(soccerPlayerDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("detail/{id}")
    public SoccerPlayer getSoccerPlayerDetail(@PathVariable int id) {
        return iSoccerPlayerService.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteSoccer(@PathVariable int id){
        iSoccerPlayerService.deleteSoccer(id);
    }
}
