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
    private int id;
    private String detalhes;
    private String nota;

    @ManyToOne // Relacionamento n para 1
    @JoinColumn(name="id_livro") //referencia para objeto filme
    private Filme filme;
    
    
//    public Analise() {
//    }
//
//    public Analise(int id, Filme filme, String detalhes, String nota) {
//        this.id = id;
//        this.filme = filme;
//        this.detalhes = detalhes;
//        this.nota = nota;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Filme getFilme() {
//        return filme;
//    }
//
//    public void setFilme(Filme filme) {
//        this.filme = filme;
//    }
//
//    public String getDetalhes() {
//        return detalhes;
//    }
//
//    public void setDetalhes(String detalhes) {
//        this.detalhes = detalhes;
//    }
//
//    public String getNota() {
//        return nota;
//    }
//
//    public void setNota(String nota) {
//        this.nota = nota;
//    }

}
