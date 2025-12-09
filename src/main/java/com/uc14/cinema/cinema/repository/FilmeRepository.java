package com.uc14.cinema.cinema.repository;

import com.uc14.cinema.cinema.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<Filme,Integer> {
   
}
