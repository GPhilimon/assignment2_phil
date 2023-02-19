package com.assignment1.clothes.controller;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assignment1.clothes.model.Clothe;
import com.assignment1.clothes.model.Clothe.Brand;
import com.assignment1.clothes.repository.ClotheRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private ClotheRepository clotheRepository;

    @ModelAttribute
    public Clothe clothe() {
        return Clothe.builder().build();
    }

    @ModelAttribute
    public void getAllBrands(Model model) {
        var brands = EnumSet.allOf(Brand.class);
        model.addAttribute("brands", brands);
        log.info("brands: ", brands);
    }

    @GetMapping
    @ModelAttribute
    public String getHome(Model model) {
        // model.addAttribute("message", "Clothes Warehouse");
        return "home";
    }

    @PostMapping
    public String insertClothe(@Valid Clothe clothe, BindingResult result) {
        if (result.hasErrors()) {
            return "home";
        }

        clotheRepository.save(clothe);
        return "redirect:/clotheslist";
    }
}
