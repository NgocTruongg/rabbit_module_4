package com.example.ung_dung_chuyen_doi_tien_te.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class conversion {
    @GetMapping("/convert")
    public String chuyenDoi(@RequestParam(required = false) Double USD, Model model) {
        if (USD == null) {
            model.addAttribute("USD", USD);
            return "/result";
        }
        double VND = USD * 24000;
        model.addAttribute("VND", VND);
        model.addAttribute("USD", USD);
        return "/result";
    }
}
