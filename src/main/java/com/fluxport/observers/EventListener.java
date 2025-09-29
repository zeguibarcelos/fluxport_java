package com.fluxport.observers;

import com.fluxport.model.embarcacoes.EmbarcacaoBase;

public interface EventListener {
    void onEmbarcacaoAtracada(EmbarcacaoBase embarcacao);
}