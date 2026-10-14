package com.xmen.sentinela.domain;

public class Alvo {
    private String nome;
    private TipoAlvo tipo;
    private int nivelPoder;

    public Alvo(String nome, TipoAlvo tipo, int nivelPoder) {
        this.nome = nome;
        this.tipo = tipo;
        this.nivelPoder = nivelPoder;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public TipoAlvo getTipo() { return tipo; }
    public void setTipo(TipoAlvo tipo) { this.tipo = tipo; }
    public int getNivelPoder() { return nivelPoder; }
    public void setNivelPoder(int nivelPoder) { this.nivelPoder = nivelPoder; }
}
