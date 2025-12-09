package com.uc14.cinema.cinema.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


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

    public Analise(Integer id, String detalhes, String nota, Filme filme) {
        this.id = id;
        this.detalhes = detalhes;
        this.nota = nota;
        this.filme = filme;
    }

    public Analise() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    
    
}
