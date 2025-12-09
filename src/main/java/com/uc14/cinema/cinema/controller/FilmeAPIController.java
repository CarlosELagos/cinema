package com.uc14.cinema.cinema.controller;

import com.uc14.cinema.cinema.model.Filme;
import com.uc14.cinema.cinema.service.FilmeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/filme")
public class FilmeAPIController {
    
    @Autowired
    FilmeService filmeService; //injeta a service no repository
    
    //cadastrando
    @PostMapping("/adicionar")
    public ResponseEntity<Filme> create (@RequestBody Filme filme){
        Filme newFilme = filmeService.criar(filme);
        return new ResponseEntity<>(newFilme,HttpStatus.CREATED);
    }
    
    @GetMapping("/listaTudo")
    public ResponseEntity<List> listar() {
        List<Filme> listarTodosFilmes = filmeService.busca();
        return new ResponseEntity<>(listarTodosFilmes,HttpStatus.OK);
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Filme> buscar(@PathVariable Integer id) {
        Filme filmeLocalizado = filmeService.buscaId(id);
        return new ResponseEntity<(filmeLocalizado,HttpStatus.OK);
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Filme> atualizar(@PathVariable Integer id, @RequestBody Filme filme) {
        Filme filmeAtualizado = filmeService.atualizar(id, filme);
        return new ResponseEntity<>(filmeAtualizado, HttpStatus.OK);
    }
    
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Filme> excluir (@PatchVariable Integer id) {
        filmeService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
