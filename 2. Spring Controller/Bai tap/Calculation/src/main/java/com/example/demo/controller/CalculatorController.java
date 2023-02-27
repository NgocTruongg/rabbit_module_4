package com.example.demo.controller;

import com.example.demo.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    ICalculatorService calculatorService;

    @GetMapping("")
    public String calculation(@RequestParam(required = false) Double firstNumber, Double secondNumber, String calculation, Model model) {
        if (firstNumber == null && secondNumber == null) {
            return "/calculator";
        }
        String message = "";
        String calculationMessage = "";
        double result = calculatorService.performCalculator(calculation, firstNumber, secondNumber);
        switch (calculation){
            case "Addition":
                calculationMessage = "Addition";
                break;
            case "Subtraction":
                calculationMessage = "Subtraction";
                break;
            case "Multiplication":
                calculationMessage = "Multiplication";

                break;
            case "Division":
                if (result != 0) {
                    calculationMessage = "Division";
                } else {
                    message = "please enter a number other than 0";
                }
                break;
        }
        model.addAttribute("firstNumber", firstNumber);
        model.addAttribute("secondNumber", secondNumber);
        model.addAttribute("calculationMessage", calculationMessage);
        model.addAttribute("message", message);
        model.addAttribute("result", result);
        return "/calculator";
    }
}

