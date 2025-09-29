package com.fluxport.strategies;

import java.util.List;

import com.fluxport.model.Doca;
import com.fluxport.model.embarcacoes.EmbarcacaoBase;

public interface DockingStrategy {
    Doca escolherDoca(List<Doca> docas, EmbarcacaoBase embarcacao);
}