package com.example.exercise_spring_boot.controller;

import com.example.exercise_spring_boot.dto.SoccerPlayerDTO;
import com.example.exercise_spring_boot.model.SoccerPlayer;
import com.example.exercise_spring_boot.service.IFootballTeamService;
import com.example.exercise_spring_boot.service.ISoccerPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/soccer-player")
@SessionAttributes("soccerPlayerFavorites")
public class SoccerPlayerController {

    @Autowired
    private ISoccerPlayerService iSoccerPlayerService;

    @ModelAttribute("soccerPlayerFavorites")
    public List<SoccerPlayer> soccerPlayers() {
        return new ArrayList<>();
    }

    @Autowired
    private IFootballTeamService iFootballTeamService;

    @GetMapping("")
    public String showList(Model model, @RequestParam(defaultValue = "", required = false) String name,
                           @RequestParam(defaultValue = "1") Integer page,
                           @PageableDefault(size = 3) Pageable pageable) {
        Sort sort = null;
        if (name == name) {
            sort = Sort.by("dateOfBirth").ascending();
        } else {
            sort = Sort.by("name").ascending();
        }
        Pageable sortPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        Page<SoccerPlayer> soccerPlayerPage = iSoccerPlayerService.findAll(name, sortPageable);
        model.addAttribute("soccerPlayerList", soccerPlayerPage);
        model.addAttribute("name", name);
        List<Integer> pageNumberList = new ArrayList<>();
        for (int i = 1; i <= soccerPlayerPage.getTotalPages(); i++) {
            pageNumberList.add(i);
        }
        model.addAttribute("pageNumberList", pageNumberList);
        return "/list";
    }

    @GetMapping("/detail/{id}")
    public String detailSoccerPlayer(@PathVariable("id") int id, @CookieValue("countSoccerFavorites") Integer countSoccerFavorites,
                                     HttpServletResponse servletResponse,
                                     RedirectAttributes redirectAttributes,
                                     Model model) {
        SoccerPlayer soccerPlayer = iSoccerPlayerService.findById(id);
        Cookie cookie = new Cookie("countSoccerFavorites", ++countSoccerFavorites + "");
        servletResponse.addCookie(cookie);
        cookie.setMaxAge(1 * 24 * 60 * 60);
        redirectAttributes.addAttribute("countSoccerFavorites", countSoccerFavorites);
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
        model.addAttribute("footballTeamList", iFootballTeamService.findAll());
        return "/create";
    }

    @PostMapping("/create")
    public String createSoccerPlayer(@Validated @ModelAttribute("soccerPlayer") SoccerPlayerDTO soccerPlayerDTO,
                                     BindingResult bindingResult,
                                     Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("footballTeamList", iFootballTeamService.findAll());
            return "/create";
        }
        new SoccerPlayerDTO().validate(soccerPlayerDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("footballTeamList", iFootballTeamService.findAll());
            return "/create";
        } else {
            iSoccerPlayerService.create(soccerPlayerDTO);
            return "redirect:/soccer-player";
        }
    }

    @GetMapping("/update")
    public String showUpdateSoccerPlayer(@RequestParam(required = false) int id, Model model) {
        model.addAttribute("soccerPlayer", iSoccerPlayerService.findById(id));
        model.addAttribute("footballTeamList", iFootballTeamService.findAll());
        return "/update";
    }

    @PostMapping("/update")
    public String updateSoccerPlayer(@ModelAttribute SoccerPlayer soccerPlayer) {
        iSoccerPlayerService.update(soccerPlayer);
        return "redirect:/soccer-player";
    }

    @GetMapping("/register")
    public String registerSoccerPlayer(@RequestParam int idRegister) {
        SoccerPlayer soccerPlayer = iSoccerPlayerService.findById(idRegister);
        iSoccerPlayerService.register(soccerPlayer);
        return "redirect:/soccer-player";
    }

    @GetMapping("add-room/{id}")
    public String addFavorites(@PathVariable("id") Integer id,
                               @ModelAttribute("soccerPlayerFavorites") List<SoccerPlayer> soccerPlayers,
                               RedirectAttributes redirectAttributes) {
        SoccerPlayer soccerPlayer = iSoccerPlayerService.findById(id);
        redirectAttributes.addFlashAttribute("msg", "Thêm vào danh sách yêu thích thành công!!!");
        soccerPlayers.add(soccerPlayer);
        return "redirect:/soccer-player";
    }
    @ExceptionHandler(Exception.class)
    public String handel(){
        return "/error";
    }
}
