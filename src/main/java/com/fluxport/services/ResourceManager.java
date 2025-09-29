package com.fluxport.services;

import java.util.ArrayList;
import java.util.List;

import com.fluxport.model.embarcacoes.EmbarcacaoBase;

public class ResourceManager {
    private static ResourceManager instance;
    private List<EmbarcacaoBase> embarcacoes = new ArrayList<>();

    private ResourceManager() {}

    public static synchronized ResourceManager getInstance() {
        if (instance == null) {
            instance = new ResourceManager();
        }
        return instance;
    }

    public void addEmbarcacao(EmbarcacaoBase e) {
        embarcacoes.add(e);
    }

    public List<EmbarcacaoBase> getEmbarcacoes() {
        return embarcacoes;
    }
}