package com.exemplo.pocketagenda;

public class Compromisso {
    private final String titulo;
    private final String data;

    public Compromisso(String titulo, String data) {
        this.titulo = titulo;
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getData() {
        return data;
    }
}
