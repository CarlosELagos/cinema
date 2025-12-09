package com.uc14.cinema.cinema.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Analise")
public class Analise {

    @Id //chave primaria
    @GeneratedValue(strategy = GenerationType.AUTO) //auto incremento
    private Integer id;
    private String detalhes;
    private String nota;

    @ManyToOne // Relacionamento n para 1
    @JoinColumn(name="id_filme") //referencia para objeto filme
    private Filme filme;

}
