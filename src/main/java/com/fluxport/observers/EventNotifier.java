package com.fluxport.observers;

import java.util.ArrayList;
import java.util.List;

import com.fluxport.model.embarcacoes.EmbarcacaoBase;

public class EventNotifier {
    private List<EventListener> listeners = new ArrayList<>();

    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

    public void notifyEmbarcacaoAtracada(EmbarcacaoBase e) {
        for (EventListener l : listeners) {
            l.onEmbarcacaoAtracada(e);
        }
    }
}