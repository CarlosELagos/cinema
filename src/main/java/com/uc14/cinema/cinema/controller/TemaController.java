package com.uc14.cinema.cinema.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class TemaController {
    @ModelAttribute
    public void addTema(
    @CookieValue(name = "pref-estilo" , defaultValue = "claro") String tema, Model model){
        model.addAttribute("css", tema);
    }
     
}
