package com.uc14.cinema.cinema.model;

public class Analise {

    private int id;
    private Filme filme;
    private String detalhes;
    private String nota;

    public Analise() {
    }

    public Analise(int id, Filme filme, String detalhes, String nota) {
        this.id = id;
        this.filme = filme;
        this.detalhes = detalhes;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
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

}
