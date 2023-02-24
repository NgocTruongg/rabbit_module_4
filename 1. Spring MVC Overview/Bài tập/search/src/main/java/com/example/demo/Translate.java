package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Translate {

    private static final Map<String, String> lisMap = new HashMap<>();

    static {
        lisMap.put("pool", "Hồ bơi");
        lisMap.put("Car", "Ô tô");
        lisMap.put("Water", "Nước");
        lisMap.put("Swimming", "Bơi lội");
    }

    @GetMapping("/search")
    public String search(@RequestParam(required = false) String word, Model model) {
        if (word == null) {
            model.addAttribute("'search", "không tìm thấy");
            return "/search";
        }
        model.addAttribute("search", lisMap.get(word));
        return "/search";
    }
}
