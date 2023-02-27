package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService{
    @Override
    public double performCalculator(String calculation, double firstNumber, double secondNumber) {
        switch (calculation) {
            case "Addition":
                return firstNumber + secondNumber;
            case "Subtraction":
                return firstNumber - secondNumber;
            case "Multiplication":
                return firstNumber * secondNumber;
            case "Division":
                if (secondNumber != 0) {
                    return firstNumber / secondNumber;
                } else {
                    return 0;
                }
        }
        return 0;
    }
}
