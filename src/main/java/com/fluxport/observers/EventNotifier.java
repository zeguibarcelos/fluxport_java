package com.fluxport.observers;

import java.util.ArrayList;
import java.util.List;

import com.fluxport.model.embarcacoes.EmbarcacaoBase;

// Notificador de eventos de embarcações
public class EventNotifier {

    private final List<EventListener> listeners = new ArrayList<>();

    // Adiciona um listener
    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

    // Notifica todos os listeners que a embarcação foi atracada
    public void notifyEmbarcacaoAtracada(EmbarcacaoBase embarcacao) {
        for (EventListener listener : listeners) {
            listener.onEmbarcacaoAtracada(embarcacao);
        }
    }

    // Notifica todos os listeners que a embarcação foi desatracada
    public void notifyEmbarcacaoDesatracada(EmbarcacaoBase embarcacao) {
        for (EventListener listener : listeners) {
            listener.onEmbarcacaoDesatracada(embarcacao);
        }
    }
}
