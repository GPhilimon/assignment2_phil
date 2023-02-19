package com.assignment1.clothes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assignment1.clothes.repository.ClotheRepository;

@Controller
@RequestMapping("clotheslist")
public class ClothesListController {

    @Autowired
    private ClotheRepository clotheRepository;

    @ModelAttribute
    public void findAllClothes(Model model) {
        model.addAttribute("clothes", clotheRepository.findAll());
    }

    @GetMapping
    public String getClothesList() {
        return "clothesList";
    }
}
