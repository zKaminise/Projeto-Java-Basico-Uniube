package com.example.JavaProjectUniube.Entity;

public class LivroInfantil extends Livro{
    private String faixaEtaria;

    public LivroInfantil(String titulo, boolean disponivel, int anoPublicacao, Autor autor, String faixaEtaria) {
        super(titulo, disponivel, anoPublicacao, autor);
        this.faixaEtaria = faixaEtaria;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Faixa Etária: " + faixaEtaria;
    }
}
