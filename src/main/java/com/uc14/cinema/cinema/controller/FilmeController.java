package com.uc14.cinema.cinema.controller;

import com.uc14.cinema.cinema.model.Analise;
import com.uc14.cinema.cinema.model.Filme;
import com.uc14.cinema.cinema.repository.FilmeRepository;
import com.uc14.cinema.cinema.service.FilmeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilmeController {

    @Autowired
    FilmeRepository filmeRepository;
    @Autowired
    private FilmeService filmeService;

    List<Filme> listaFilmes = new ArrayList<>();
    List<Analise> listaAnalises = new ArrayList<>();

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/inicio")
    public String inicio() {
        return "home";
    }

    @GetMapping("/cadastro")
    public String formulario(Model model) {
        model.addAttribute("filme", new Filme());
        return "cadastro";
    }
    
       @PostMapping("/atualiza")
    public String atualizarFilme(@ModelAttribute Filme filme) {
        filmeService.atualizar(filme.getId(), filme);
        return "redirect:/listador"; // volta para a lista
    }


    
    @PostMapping("/gravar")
    public String gravaFilme(@ModelAttribute Filme filme, Model model) {
        filme.setId(listaFilmes.size() + 1);
        listaFilmes.add(filme);

        return "redirect:/listador";
    }

    @GetMapping("/listador")
    public String listaFilme(Model model) {
        List<Filme> filmes = filmeService.busca();
        model.addAttribute("filmes", filmes);
        return "lista";
    }

    @GetMapping("/detalhes")
//    public String detalhes(Model model){
    public String detalhe(Model model, @RequestParam String id) {
        Integer idFilme = Integer.parseInt(id);
        Filme foundMovie = new Filme();

        for (Filme f : listaFilmes) {
            if (f.getId() == idFilme) {
                foundMovie = f;
            }
        }

        List<Analise> analisesFound = new ArrayList<>();
        for (Analise an : listaAnalises) {
            if (an.getFilme().getId() == idFilme) {
                analisesFound.add(an);
            }
        }

        model.addAttribute("filme", foundMovie);
        model.addAttribute("analise", new Analise());
        model.addAttribute("analises", analisesFound);

        return "detalhes";
    }

    @PostMapping("/gravar-analises")
    public String gravaUsuario(@ModelAttribute Filme filme, @ModelAttribute Analise analise, Model model) {
        analise.setId(listaAnalises.size() + 1);
        analise.setFilme(filme);
        listaAnalises.add(analise);

        return "redirect:/listador";
    }

    @PostMapping("/filmes/{id}/delete")
    public String deletarFilme(@PathVariable Integer id) {
        filmeRepository.deleteById(id);
        return "redirect:/";
    }

}
