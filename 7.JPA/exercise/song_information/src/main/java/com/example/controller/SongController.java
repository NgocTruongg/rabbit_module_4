package com.example.controller;

import com.example.dto.SongDTO;
import com.example.model.Song;
import com.example.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("song")
public class SongController {

    @Autowired
    private ISongService iSongService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("songList", iSongService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm (Model model){
        model.addAttribute("songDTO", new SongDTO());
        return "create";
    }
    @PostMapping("create")
    public String perFormCreate(@Valid @ModelAttribute SongDTO songDTO,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDTO, song);
        iSongService.createSong(song);
        redirectAttributes.addFlashAttribute("msg", "msg.createSuccess");
        return "redirect:/song";
    }

    @GetMapping("edit")
    public String showEditForm(@RequestParam Integer id, Model model){
        SongDTO songDTO = new SongDTO();
        BeanUtils.copyProperties(iSongService.findById(id), songDTO);
        model.addAttribute("songDTO", songDTO);
        return "edit";
    }
    @PostMapping("edit")
    public String perFormEdit(@Valid @ModelAttribute SongDTO songDTO,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDTO, song);
        iSongService.updateSong(song);
        redirectAttributes.addFlashAttribute("msg", "msg.editSuccess");
        return "redirect:/song";
    }
}
