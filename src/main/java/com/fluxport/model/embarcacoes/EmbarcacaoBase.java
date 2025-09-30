package com.fluxport.model.embarcacoes;

import com.fluxport.enums.Status;
import com.fluxport.model.Carga;
import com.fluxport.model.Doca;

import java.util.ArrayList;
import java.util.List;

import com.fluxport.enums.TipoEmbarcacao;

public abstract class EmbarcacaoBase {

    private Long id;
    private String nome, bandeira, proprietario;
    private Status status = Status.EM_VIAGEM;
    private List<Carga> cargas = new ArrayList<>();
    private Doca doca;
    private final TipoEmbarcacao tipo;
    private double comprimento; // metros
    private double largura;     // metros

    protected EmbarcacaoBase(Long id, String nome, String bandeira, String proprietario, TipoEmbarcacao tipo, double comprimento, double largura) {
        this.id = id;
        this.nome = nome;
        this.bandeira = bandeira;
        this.proprietario = proprietario;
        this.tipo = tipo;
        this.comprimento = comprimento;
        this.largura = largura;
    }

    // Atracar a uma doca
    public void atracar(Doca doca) {
        this.doca = doca;
        status = Status.ATRACADA;
    }

    // Deixar o porto
    public void zarpar() {
        status = Status.EM_VIAGEM;
        this.doca = null;
    }

    // Adicionar carga
    public void carregar(Carga carga) {
        cargas.add(carga);
    }

    public void setDoca(Doca doca) {
        this.doca = doca;
    }

    public TipoEmbarcacao getTipo() {
        return tipo;
    }

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

    public Status getStatus() {
        return status;
    }

    public Doca getDoca() {
        return doca;
    }

    public double getComprimento() {
        return comprimento;
    }

    public double getLargura() {
        return largura;
    }
}
