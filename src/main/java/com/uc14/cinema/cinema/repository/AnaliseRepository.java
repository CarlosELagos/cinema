package com.uc14.cinema.cinema.repository;

import com.uc14.cinema.cinema.model.Analise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnaliseRepository extends JpaRepository<Analise, Integer> {
    
}
