package com.fluxport.controller;

import com.fluxport.model.Doca;
import com.fluxport.model.embarcacoes.EmbarcacaoBase;
import com.fluxport.dto.EmbarcacaoRequest;
import com.fluxport.factories.EmbarcacaoFactory;
import com.fluxport.observers.EventNotifier;
import com.fluxport.services.DockingService;
import com.fluxport.strategies.PrimeiroLivreStrategy;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost") // libera só seu PHP local
public class PortoController {

    private List<Doca> docas = new ArrayList<>();
    private EventNotifier notifier = new EventNotifier();
    private DockingService dockingService;

    public PortoController() {
        // Inicia o service utilizando a estrategia de escolher a primeira doca livre encontrada
        this.dockingService = new DockingService(new PrimeiroLivreStrategy(), notifier);

        // Criando docas do porto
        docas.add(new Doca(1L, "Doca A"));
        docas.add(new Doca(2L, "Doca B"));
        docas.add(new Doca(3L, "Doca C"));

        // Adicionando listener
        notifier.addListener((EmbarcacaoBase e) -> {
            System.out.println(
                    "Evento: Embarcação " + e.getNome() +
                            " | Bandeira: " + e.getBandeira() +
                            " | Proprietário: " + e.getProprietario() +
                            " atracada na doca " + e.getDoca().getNome());
        });
    }

    @PostMapping("/atracar")
    public String atracar(@RequestBody EmbarcacaoRequest request) {
        EmbarcacaoBase embarcacao = EmbarcacaoFactory.criarEmbarcacao(
                request.getTipo(),
                request.getId(),
                request.getNome(),
                request.getBandeira(),
                request.getProprietario());

        boolean sucesso = dockingService.atracar(embarcacao, docas);

        return sucesso ? "Embarcação atracada" : "Não há docas disponíveis";
    }
}
