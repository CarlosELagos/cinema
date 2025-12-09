package com.uc14.cinema.cinema.service;

import com.uc14.cinema.cinema.model.Analise;
import com.uc14.cinema.cinema.repository.AnaliseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnaliseService {
    
    @Autowired
    AnaliseRepository analiseRepository;
    
    public Analise gerar (Analise analise){
        analise.setId(null);
        analiseRepository.save(analise);
        return analise;
    }
    
    public List<Analise> listando(Integer idFilme) {
    return analiseRepository.findByFilmeId(idFilme);
}
    
}
