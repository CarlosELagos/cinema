package com.uc14.cinema.cinema.service;

import com.uc14.cinema.cinema.model.Filme;
import com.uc14.cinema.cinema.repository.FilmeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FilmeService {
    // injetar classe repositorio
    @Autowired
    FilmeRepository filmeRepository;
    
    //CRUD
    
    public Filme criar(Filme filme) {
//        filme.setId(null);
        filmeRepository.save(filme);
        return filme;
    }
    
    public List<Filme> busca(){
    return filmeRepository.findAll();
    }
    
    public void excluir(Integer id) {
        Filme filmeLocalizado = buscaId(id);
        filmeRepository.deleteById(filmeLocalizado.getId());
    }

    public Filme buscaId (Integer id) {
        return filmeRepository.findById(id).orElseThrow();
    }
    
    public Filme atualizar(Integer id, Filme filme){
        Filme filmeLocalizado = buscaId(id);
        
        filmeLocalizado.setTitulo(filme.getTitulo());
        filmeLocalizado.setGenero(filme.getGenero());
        filmeLocalizado.setAnoLancamento(filme.getAnoLancamento());
        filmeLocalizado.setSinopse(filme.getSinopse());
        filmeRepository.save(filmeLocalizado);
        return filmeLocalizado;
    }
    
}
