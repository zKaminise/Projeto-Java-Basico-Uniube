package com.example.JavaProjectUniube.Entity;

public class Livro {
    private String titulo;
    private Autor autor;
    private int anoPublicacao;
    private boolean disponivel;

    public Livro(String titulo, boolean disponivel, int anoPublicacao, Autor autor) {
        this.titulo = titulo;
        this.disponivel = disponivel;
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;
    }

    public Livro(){};

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Livro: " + titulo +
                ", Autor: " + autor.getNome() +
                ", Ano de Publicação: " + anoPublicacao +
                ", Disponivel: " + (disponivel ? "Sim" : "Não");
    }
}
