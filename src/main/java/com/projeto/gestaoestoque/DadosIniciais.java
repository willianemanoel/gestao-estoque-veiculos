package com.projeto.gestaoestoque;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DadosIniciais {

    @Bean
    CommandLineRunner carregarDadosIniciais(
            MarcaRepository marcaRepository,
            ModeloRepository modeloRepository,
            VeiculoRepository veiculoRepository
    ) {
        return args -> {
            Marca toyota = marcaRepository.findByNomeIgnoreCase("Toyota")
                    .orElseGet(() -> marcaRepository.save(criarMarca("Toyota")));

            Marca honda = marcaRepository.findByNomeIgnoreCase("Honda")
                    .orElseGet(() -> marcaRepository.save(criarMarca("Honda")));

            Modelo corolla = modeloRepository.findByNomeIgnoreCaseAndMarca_Id("Corolla", toyota.getId())
                    .orElseGet(() -> modeloRepository.save(criarModelo("Corolla", toyota)));

            Modelo civic = modeloRepository.findByNomeIgnoreCaseAndMarca_Id("Civic", honda.getId())
                    .orElseGet(() -> modeloRepository.save(criarModelo("Civic", honda)));

            if (veiculoRepository.count() == 0) {
                veiculoRepository.save(criarVeiculo(corolla, 2022, "Prata", 120000.0, 20000, "Disponível"));
                veiculoRepository.save(criarVeiculo(civic, 2021, "Preto", 110000.0, 30000, "Vendido"));
            }
        };
    }

    private Marca criarMarca(String nome) {
        Marca marca = new Marca();
        marca.setNome(nome);
        return marca;
    }

    private Modelo criarModelo(String nome, Marca marca) {
        Modelo modelo = new Modelo();
        modelo.setNome(nome);
        modelo.setMarca(marca);
        return modelo;
    }

    private Veiculo criarVeiculo(Modelo modelo, int ano, String cor, double preco, int quilometragem, String status) {
        Veiculo veiculo = new Veiculo();
        veiculo.setModelo(modelo);
        veiculo.setAno(ano);
        veiculo.setCor(cor);
        veiculo.setPreco(preco);
        veiculo.setQuilometragem(quilometragem);
        veiculo.setStatus(status);
        return veiculo;
    }
}