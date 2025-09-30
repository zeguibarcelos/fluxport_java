package com.fluxport.model.embarcacoes;

import com.fluxport.enums.TipoEmbarcacao;

public class EmbarcacaoCarga extends EmbarcacaoBase {

    public EmbarcacaoCarga(Long id, String nome, String bandeira, String proprietario, double comprimento, double largura) {
        super(id, nome, bandeira, proprietario, TipoEmbarcacao.CARGA, comprimento, largura);
    }    
}
