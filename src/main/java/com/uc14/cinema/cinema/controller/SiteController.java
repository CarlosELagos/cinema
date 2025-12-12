package com.uc14.cinema.cinema.controller;

import com.uc14.cinema.cinema.model.Preferencia;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SiteController {

    @RequestMapping("/preferencias")
    public String preferencias() {
        return "preferencias";
    }

    @PostMapping("/preferencias")
    public ModelAndView gravaPreferencias(@ModelAttribute Preferencia pref, HttpServletResponse response) {

        String estilo = pref.getEstilo() != null ? pref.getEstilo() : "claro";

        Cookie cookiePrefEstilo = new Cookie("pref-estilo", estilo);
        cookiePrefEstilo.setDomain("localhost");
        cookiePrefEstilo.setHttpOnly(true);
        cookiePrefEstilo.setMaxAge(86400);
        response.addCookie(cookiePrefEstilo);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping("/")
    public String index(@CookieValue(name = "pref-estilo", defaultValue = "claro") String tema, Model model) {
        model.addAttribute("css", tema);
        return "home";
    }
}
