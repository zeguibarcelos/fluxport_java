package com.fluxport.observers;

import com.fluxport.model.embarcacoes.EmbarcacaoBase;

// Interface do Observer para eventos de embarcação
public interface EventListener {

    // Chamado quando uma embarcação é atracada
    void onEmbarcacaoAtracada(EmbarcacaoBase embarcacao);

    // Chamado quando uma embarcação é desatracada
    void onEmbarcacaoDesatracada(EmbarcacaoBase embarcacao);
}
