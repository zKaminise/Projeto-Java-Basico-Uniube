package com.example.JavaProjectUniube.Service;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca<T> {
    private List<T> itens;

    public Biblioteca() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(T item) {
        itens.add(item);
    }

    public void listarItens() {
        for (T item : itens) {
            System.out.println(item.toString());
        }
    }

    public T buscarItem(String criterio, Identificavel<T> identificador) {
        for (T item : itens) {
            if ( identificador.identificar(item, criterio)) {
                return item;
            }
        }
        return null;
    }

    public interface Identificavel<T> {
        boolean identificar(T item, String criterio);
    }

}
