package com.fluxport.services;

import com.fluxport.model.Doca;
import com.fluxport.model.embarcacoes.EmbarcacaoBase;
import com.fluxport.strategies.DockingStrategy;
import com.fluxport.observers.EventNotifier;

import java.util.List;

public class DocaService {

    private final DockingStrategy strategy;
    private final EventNotifier notifier;

    public DocaService(DockingStrategy strategy, EventNotifier notifier) {
        this.strategy = strategy;
        this.notifier = notifier;
    }

    // Atracar embarcação para uma doca disponível
    public boolean atracar(EmbarcacaoBase embarcacao, List<Doca> docas) {
        // Utiliza a estrategia selecionada para escolher uma doca
        Doca docaEscolhida = strategy.escolherDoca(docas, embarcacao);

        // Se não encontrar uma doca disponivel com base nos criterios da estrategia,
        // retorna falso
        if (docaEscolhida == null) {
            return false;
        }

        // Ocupa a doca com a embarcação
        docaEscolhida.ocupar(embarcacao);

        // Notifica aos listeners
        notifier.notifyEmbarcacaoAtracada(embarcacao);
        return true;
    }

    // Desatracar embarcação
    public boolean desatracar(EmbarcacaoBase embarcacao) {
        Doca doca = embarcacao.getDoca();

        // Desocupa a doca
        doca.desocupar(embarcacao);

        // Notifica aos listeners
        notifier.notifyEmbarcacaoDesatracada(embarcacao);
        return true;
    }
}
