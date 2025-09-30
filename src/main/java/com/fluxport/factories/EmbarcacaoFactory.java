package com.fluxport.factories;

import com.fluxport.enums.TipoEmbarcacao;
import com.fluxport.model.embarcacoes.EmbarcacaoBase;
import com.fluxport.model.embarcacoes.EmbarcacaoCarga;
import com.fluxport.model.embarcacoes.EmbarcacaoPetroleiro;
import com.fluxport.model.embarcacoes.EmbarcacaoRebocador;

public class EmbarcacaoFactory {

    public static EmbarcacaoBase criarEmbarcacao(TipoEmbarcacao tipo, Long id, String nome, String bandeira, String proprietario) {
        switch (tipo) {
            case CARGA:
                return new EmbarcacaoCarga(id, nome, bandeira, proprietario);
            case PETROLEIRO:
                return new EmbarcacaoPetroleiro(id, nome, bandeira, proprietario);
            case REBOCADOR:
                return new EmbarcacaoRebocador(id, nome, bandeira, proprietario);
            default:
                throw new IllegalArgumentException("Tipo inválido");
        }
    }
}
