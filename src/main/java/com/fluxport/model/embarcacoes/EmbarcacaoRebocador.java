package com.fluxport.model.embarcacoes;

import com.fluxport.enums.TipoEmbarcacao;

public class EmbarcacaoRebocador extends EmbarcacaoBase {

    public EmbarcacaoRebocador(Long id, String nome, String bandeira, String proprietario, double comprimento, double largura) {
        super(id, nome, bandeira, proprietario, TipoEmbarcacao.REBOCADOR, comprimento, largura);
    }    
}
