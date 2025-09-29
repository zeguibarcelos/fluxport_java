package com.fluxport.strategies;

import java.util.List;

import com.fluxport.model.Doca;
import com.fluxport.model.embarcacoes.EmbarcacaoBase;

public class PrimeiroLivreStrategy implements DockingStrategy {
    @Override
    public Doca escolherDoca(List<Doca> docas, EmbarcacaoBase embarcacao) {
        return docas.stream().filter(Doca::isDisponivel).findFirst().orElse(null);
    }
}