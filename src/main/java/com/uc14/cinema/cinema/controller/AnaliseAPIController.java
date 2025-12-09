package com.uc14.cinema.cinema.controller;

import com.uc14.cinema.cinema.model.Analise;
import com.uc14.cinema.cinema.service.AnaliseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analise")
public class AnaliseAPIController {

    @Autowired
    AnaliseService analiseService;

    @PostMapping("/adicionar")
    public ResponseEntity<Analise> addAnalise(@RequestBody Analise ana) {
        Analise novaAnalise = analiseService.gerar(ana);
        return new ResponseEntity<>(novaAnalise, HttpStatus.CREATED);
    }
    
    @GetMapping ("/pesquisa/{idFilme}")
    public ResponseEntity<List> listaAnalises(@PathVariable Integer idFilme){
        List<Analise> lista = analiseService.listando(idFilme);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    
}
