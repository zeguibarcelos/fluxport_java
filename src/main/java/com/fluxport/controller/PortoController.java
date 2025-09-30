package com.fluxport.controller;

import com.fluxport.model.Doca;
import com.fluxport.model.embarcacoes.EmbarcacaoBase;
import com.fluxport.dto.EmbarcacaoRequest;
import com.fluxport.factories.EmbarcacaoFactory;
import com.fluxport.observers.EventNotifier;
import com.fluxport.services.DocaService;
import com.fluxport.strategies.PrimeiroLivreStrategy;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.fluxport.dto.AtracarRequest;
import com.fluxport.dto.EmbarcacaoResponse;
import com.fluxport.enums.TipoEmbarcacao;
import com.fluxport.model.embarcacoes.EmbarcacaoCarga;
import com.fluxport.model.embarcacoes.EmbarcacaoPetroleiro;
import com.fluxport.model.embarcacoes.EmbarcacaoRebocador;
import com.fluxport.strategies.DockingStrategy;

// Controlador principal do projeto
@RestController
public class PortoController {

    private final List<Doca> docas;
    private final List<EmbarcacaoBase> embarcacoes;
    private final EventNotifier notifier;
    private final DocaService dockingService;

    public PortoController() {
        docas = new ArrayList<>();
        embarcacoes = new ArrayList<>();

        // Cria o notifier e adiciona um listener
        notifier = new EventNotifier();
        notifier.addListener((EmbarcacaoBase e) -> {
            System.out.println(
                    "Evento: Embarcação " + e.getNome()
                    + " | Bandeira: " + e.getBandeira()
                    + " | Proprietário: " + e.getProprietario()
                    + " atracada na doca " + e.getDoca().getNome()
            );
        });

        // Estrategia de alocação de doca
        DockingStrategy estrategiaDoca = new PrimeiroLivreStrategy();

        // Inicia o service utilizando a estratégia desejada e passando o notifier
        dockingService = new DocaService(estrategiaDoca, notifier);

        // Cria as docas do porto
        docas.add(new Doca(1L, "Doca A", 300, 50));
        docas.add(new Doca(2L, "Doca B", 250, 40));
        docas.add(new Doca(3L, "Doca C", 200, 35));

        // Adicionando embarcações iniciais
        embarcacoes.add(new EmbarcacaoCarga(1L,
                "MV Atlantic Star",
                "BR",
                "TransMarítima Ltda",
                100,
                40));
        embarcacoes
                .add(new EmbarcacaoPetroleiro(2L,
                        "SS Ocean Spirit",
                        "BR",
                        "Petrobras",
                        250,
                        45));
        embarcacoes
                .add(new EmbarcacaoRebocador(3L,
                        "RB Fortaleza",
                        "BR",
                        "Porto Serviços",
                        30,
                        10));
    }

    // Atraca a embarcação em uma doca disponível
    @PostMapping("/atracar")
    public String atracar(@RequestBody AtracarRequest request) {
        if (request.getId() == null) {
            return "ID da embarcação é obrigatório";
        }

        // Procura a embarcação existente pelo ID
        EmbarcacaoBase embarcacao = embarcacoes.stream()
                .filter(e -> e.getId().equals(request.getId()))
                .findFirst()
                .orElse(null);

        if (embarcacao == null) {
            return "Embarcação não encontrada";
        }

        boolean sucesso = dockingService.atracar(embarcacao, docas);

        return sucesso ? "Embarcação atracada" : "Não há docas disponíveis";
    }

    // Desatraca a embarcação e libera a doca
    @PostMapping("/desatracar")
    public String desatracar(@RequestBody AtracarRequest request) {
        if (request.getId() == null) {
            return "ID da embarcação é obrigatório";
        }

        // Procura a embarcação existente pelo ID
        EmbarcacaoBase embarcacao = embarcacoes.stream()
                .filter(e -> e.getId().equals(request.getId()))
                .findFirst()
                .orElse(null);

        if (embarcacao == null) {
            return "Embarcação não encontrada";
        }

        dockingService.desatracar(embarcacao);

        return "Embarcação foi desatracada";
    }

    // Cadastra uma nova embarcação
    @PostMapping("/cadastrar")
    public String cadastrar(@RequestBody EmbarcacaoRequest request) {
        // Converte tipo recebido em um enum
        TipoEmbarcacao tipoEnum;
        try {
            tipoEnum = TipoEmbarcacao.valueOf(request.getTipo().toUpperCase());
        } catch (IllegalArgumentException e) {
            return "Tipo inválido";
        }

        // Incrementa o Id
        Long novoId = this.embarcacoes.stream()
                .mapToLong(EmbarcacaoBase::getId)
                .max()
                .orElse(0L) + 1;

        // Cria embarcação via factory
        EmbarcacaoBase embarcacao = EmbarcacaoFactory.criarEmbarcacao(
                tipoEnum,
                novoId,
                request.getNome(),
                request.getBandeira(),
                request.getProprietario()
        );

        // Adiciona a embarcação à lista
        this.embarcacoes.add(embarcacao);

        return "Embarcação cadastrada com sucesso";
    }

    // Lista todas as embarcações
    @GetMapping("/embarcacoes")
    public List<EmbarcacaoResponse> embarcacoes() {
        List<EmbarcacaoResponse> response = new ArrayList<>();

        for (EmbarcacaoBase e : embarcacoes) {
            response.add(new EmbarcacaoResponse(
                    e.getId(),
                    e.getNome(),
                    e.getStatus().name(),
                    e.getDoca() != null ? e.getDoca().getNome() : null,
                    e.getBandeira(),
                    e.getProprietario(),
                    e.getTipo().name()
            ));
        }

        return response;
    }
}
