package com.example.borrow_books.controller;


import com.example.borrow_books.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    private IBookService iBookService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("bookDTOList",iBookService.findAllBook());
        return "list";
    }
}
