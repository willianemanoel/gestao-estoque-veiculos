package com.projeto.gestaoestoque;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final ModeloRepository modeloRepository;

    public VeiculoService(VeiculoRepository veiculoRepository, ModeloRepository modeloRepository) {
        this.veiculoRepository = veiculoRepository;
        this.modeloRepository = modeloRepository;
    }

    public List<Veiculo> listar(
            String marca,
            String modelo,
            Integer ano,
            Double precoMax,
            String status
    ) {

        String marcaFiltro =
                (marca != null && !marca.isBlank()) ? marca.trim() : null;

        String modeloFiltro =
                (modelo != null && !modelo.isBlank()) ? modelo.trim() : null;

        String statusFiltro =
                (status != null && !status.isBlank()) ? status.trim() : null;

        boolean semFiltros =
                marcaFiltro == null &&
                modeloFiltro == null &&
                ano == null &&
                precoMax == null &&
                statusFiltro == null;

        if (semFiltros) {
            return veiculoRepository.findAll();
        }

        return veiculoRepository.buscarComFiltros(
        modeloFiltro,
        marcaFiltro,
        ano,
        precoMax,
        statusFiltro
);
    }

    public Veiculo criar(Veiculo veiculo) {

        if (veiculo.getModelo() == null || veiculo.getModelo().getId() == null) {
            throw new RuntimeException("Selecione um modelo.");
        }

        Modelo modelo = modeloRepository.findById(veiculo.getModelo().getId())
                .orElseThrow(() -> new RuntimeException("modelo nao encontrado"));

        validarDados(veiculo);

        veiculo.setModelo(modelo);

        return veiculoRepository.save(veiculo);
    }

    public Veiculo atualizar(Long id, Veiculo dadosAtualizados) {

        Veiculo existente = veiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("veiculo nao encontrado"));

        if (dadosAtualizados.getModelo() != null &&
                dadosAtualizados.getModelo().getId() != null) {

            Modelo modelo = modeloRepository.findById(
                    dadosAtualizados.getModelo().getId())
                    .orElseThrow(() -> new RuntimeException("modelo nao encontrado"));

            existente.setModelo(modelo);
        }

        validarDados(dadosAtualizados);

        existente.setAno(dadosAtualizados.getAno());
        existente.setCor(dadosAtualizados.getCor());
        existente.setPreco(dadosAtualizados.getPreco());
        existente.setQuilometragem(dadosAtualizados.getQuilometragem());
        existente.setStatus(dadosAtualizados.getStatus());

        return veiculoRepository.save(existente);
    }

    public void excluir(Long id) {

        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("veiculo nao encontrado"));

        veiculoRepository.delete(veiculo);
    }

    private void validarDados(Veiculo veiculo) {

        if (veiculo.getAno() == null) {
            throw new RuntimeException("informe o ano do veiculo");
        }

        if (veiculo.getAno() < 1900) {
            throw new RuntimeException("ano do veiculo invalido");
        }

        if (veiculo.getPreco() == null || veiculo.getPreco() <= 0) {
            throw new RuntimeException("informe um preço valido");
        }

        if (veiculo.getQuilometragem() != null &&
                veiculo.getQuilometragem() < 0) {

            throw new RuntimeException("quilometragem nao pode ser negativa");
        }

        if (veiculo.getStatus() == null ||
                veiculo.getStatus().isBlank()) {

            throw new RuntimeException("informe o status do veiculo");
        }

        if (veiculo.getCor() != null) {
            veiculo.setCor(veiculo.getCor().trim());
        }

        veiculo.setStatus(veiculo.getStatus().trim());
    }
}