package com.fluxport.dto;

// DTO para enviar para o frontend
public class EmbarcacaoResponse {

    private Long id;
    private String nome;
    private String bandeira;
    private String proprietario;
    private String tipo;
    private double comprimento;
    private double largura;
    private String status;
    private String doca;

    // Construtor recebendo propriedades separadamente
    public EmbarcacaoResponse(Long id, String nome, String status, String doca,
            String bandeira, String proprietario, String tipo, double comprimento, double largura) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.doca = doca;
        this.bandeira = bandeira;
        this.proprietario = proprietario;
        this.tipo = tipo;
        this.comprimento = comprimento;
        this.largura = largura;
    }

    // Getters (opcional, caso você use Jackson para JSON)
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getStatus() {
        return status;
    }

    public String getDoca() {
        return doca;
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
