package com.fluxport.dto;

public class EmbarcacaoRequest {

    private Long id;
    private String nome;
    private String bandeira;
    private String proprietario;
    private String tipo;
    private double comprimento; // metros
    private double largura;     // metros

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getBandeira() {
        return bandeira;
    }

    public String getProprietario() {
        return proprietario;
    }

    public String getTipo() {
        return tipo;
    }

    public double getComprimento() {
        return comprimento;
    }

    public double getLargura() {
        return largura;
    }
}
