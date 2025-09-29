package com.fluxport.factories;

import com.fluxport.model.embarcacoes.EmbarcacaoBase;
import com.fluxport.model.embarcacoes.EmbarcacaoCarga;
import com.fluxport.model.embarcacoes.EmbarcacaoPetroleiro;
import com.fluxport.model.embarcacoes.EmbarcacaoRebocador;

public class EmbarcacaoFactory {
    public static EmbarcacaoBase criarEmbarcacao(String tipo, Long id, String nome, String bandeira, String proprietario) {
        switch (tipo.toLowerCase()) {
            case "carga":
                return new EmbarcacaoCarga(id, nome, bandeira, proprietario);
            case "petroleiro":
                return new EmbarcacaoPetroleiro(id, nome, bandeira, proprietario);
            case "rebocador":
                return new EmbarcacaoRebocador(id, nome, bandeira, proprietario);
            default:
                throw new IllegalArgumentException("Tipo inválido");
        }
    }
}