package com.fluxport.services;

import com.fluxport.model.Doca;
import com.fluxport.model.embarcacoes.EmbarcacaoBase;
import com.fluxport.strategies.DockingStrategy;
import com.fluxport.observers.EventNotifier;

import java.util.List;

public class DockingService {
    private DockingStrategy strategy;
    private EventNotifier notifier;

    public DockingService(DockingStrategy strategy, EventNotifier notifier) {
        this.strategy = strategy;
        this.notifier = notifier;
    }

    // Atracar embarcação para uma doca disponível
    public boolean atracar(EmbarcacaoBase e, List<Doca> docas) {
        // Utiliza a estrategia selecionada para escolher uma doca
        Doca docaEscolhida = strategy.escolherDoca(docas, e);

        // Se não encontrar uma doca disponivel com base nos criterios da estrategia,
        // retorna falso
        if (docaEscolhida == null) {
            return false;
        }

        docaEscolhida.ocupar(e);
        notifier.notifyEmbarcacaoAtracada(e);
        return true;
    }
}
