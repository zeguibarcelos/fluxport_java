package com.fluxport.model.embarcacoes;

import com.fluxport.enums.TipoEmbarcacao;

public class EmbarcacaoPetroleiro extends EmbarcacaoBase {

    public EmbarcacaoPetroleiro(Long id, String nome, String bandeira, String proprietario, double comprimento, double largura) {
        super(id, nome, bandeira, proprietario, TipoEmbarcacao.PETROLEIRO, comprimento, largura);
    }    
}
