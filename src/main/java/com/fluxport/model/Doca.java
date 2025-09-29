package com.fluxport.model;

import com.fluxport.enums.Status;
import com.fluxport.model.embarcacoes.EmbarcacaoBase;

public class Doca {
    private Long id;
    private String nome;
    private Status status = Status.LIVRE;
    private EmbarcacaoBase embarcacaoAtracada;

    public Doca(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public boolean isDisponivel() {
        return status == Status.LIVRE;
    }

    public void ocupar(EmbarcacaoBase embarcacao) {
        // Primeiro vinculamos a doca à embarcação
        embarcacao.atracar(this);
        
        // Para então, vincularmos a embarcação à doca e setar o status como ocupada
        status = Status.OCUPADA;
        this.embarcacaoAtracada = embarcacao;
    }

    public void liberar() {
        status = Status.LIVRE;
    }

    public Long getId() {
        return id;
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