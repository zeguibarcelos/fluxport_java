package com.fluxport.strategies;

import java.util.List;
import com.fluxport.model.Doca;
import com.fluxport.model.embarcacoes.EmbarcacaoBase;

public class MenorSobraStrategy implements DockingStrategy {

    @Override
    public Doca escolherDoca(List<Doca> docas, EmbarcacaoBase embarcacao) {
        Doca melhorDoca = null;
        double menorSobra = Double.MAX_VALUE;

        double larguraEmbarcacao = embarcacao.getLargura();
        double comprimentoEmbarcacao = embarcacao.getComprimento();

        for (Doca doca : docas) {
            if (!doca.isDisponivel()) {
                continue;
            }

            // Verifica se a embarcação cabe na doca
            if (larguraEmbarcacao <= doca.getLarguraMax()
                    && comprimentoEmbarcacao <= doca.getComprimentoMax()) {

                double sobra = (doca.getLarguraMax() - larguraEmbarcacao)
                        + (doca.getComprimentoMax() - comprimentoEmbarcacao);

                if (sobra < menorSobra) {
                    menorSobra = sobra;
                    melhorDoca = doca;
                }
            }
        }

        return melhorDoca; // Retorna null se nenhuma doca couber a embarcação
    }
}
