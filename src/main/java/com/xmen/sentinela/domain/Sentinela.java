package com.xmen.sentinela.domain;

public class Sentinela {
    private String modelo;
    private int nivelBateria;
    private boolean emVoo;
    private int temperaturaMotor;
    private int baixasConfirmadas;

    public Sentinela(String modelo, int nivelBateria) {
        this.modelo = modelo;
        this.nivelBateria = nivelBateria;
        this.emVoo = false;
        this.temperaturaMotor = 40;
        this.baixasConfirmadas = 0;
    }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public int getNivelBateria() { return nivelBateria; }
    public void setNivelBateria(int nivelBateria) { this.nivelBateria = nivelBateria; }
    public boolean isEmVoo() { return emVoo; }
    public void setEmVoo(boolean emVoo) { this.emVoo = emVoo; }
    public int getTemperaturaMotor() { return temperaturaMotor; }
    public void setTemperaturaMotor(int temperaturaMotor) { this.temperaturaMotor = temperaturaMotor; }
    public int getBaixasConfirmadas() { return baixasConfirmadas; }
    public void setBaixasConfirmadas(int baixasConfirmadas) { this.baixasConfirmadas = baixasConfirmadas; }
    public void incrementarBaixas() { this.baixasConfirmadas++; }
}
