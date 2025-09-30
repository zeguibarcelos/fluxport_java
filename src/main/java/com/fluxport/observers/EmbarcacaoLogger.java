package com.fluxport.observers;

import com.fluxport.model.embarcacoes.EmbarcacaoBase;

// Implementação do EventListener para log de eventos
public class EmbarcacaoLogger implements EventListener {

    @Override
    public void onEmbarcacaoAtracada(EmbarcacaoBase e) {
        System.out.println(
                "Evento: Embarcação " + e.getNome()
                + " | Bandeira: " + e.getBandeira()
                + " | Proprietário: " + e.getProprietario()
                + " atracada na doca " + e.getDoca().getNome()
        );
    }

    @Override
    public void onEmbarcacaoDesatracada(EmbarcacaoBase e) {
        System.out.println(
                "Evento: Embarcação " + e.getNome()
                + " | Bandeira: " + e.getBandeira()
                + " | Proprietário: " + e.getProprietario()
                + " desatracada da doca"
        );
    }
}
