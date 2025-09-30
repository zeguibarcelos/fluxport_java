package com.fluxport.model;

import com.fluxport.enums.Status;
import com.fluxport.model.embarcacoes.EmbarcacaoBase;

public class Doca {

    private Long id;
    private String nome;
    private Status status = Status.LIVRE;
    private EmbarcacaoBase embarcacaoAtracada;

    private double comprimentoMax; // em metros
    private double larguraMax;     // em metros

    public Doca(Long id, String nome, double comprimentoMax, double larguraMax) {
        this.id = id;
        this.nome = nome;
        this.comprimentoMax = comprimentoMax;
        this.larguraMax = larguraMax;
    }

    public boolean isDisponivel() {
        return status == Status.LIVRE;
    }

    public void ocupar(EmbarcacaoBase embarcacao) {
        // Primeiro vinculamos a doca à embarcação
        embarcacao.atracar(this);

        // Para então, vincularmos a embarcação à doca e setar o status como ocupada
        this.embarcacaoAtracada = embarcacao;
        status = Status.OCUPADA;
    }

    public void desocupar(EmbarcacaoBase embarcacao) {
        embarcacao.zarpar();

        this.embarcacaoAtracada = null;
        status = Status.LIVRE;
    }

    public void liberar() {
        status = Status.LIVRE;
    }

    public Long getId() {
        return id;
    }

    public double getComprimentoMax() {
        return comprimentoMax;
    }

    public double getLarguraMax() {
        return larguraMax;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
