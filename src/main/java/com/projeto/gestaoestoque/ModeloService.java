package com.projeto.gestaoestoque;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {

    private final ModeloRepository modeloRepository;
    private final MarcaRepository marcaRepository;

    public ModeloService(ModeloRepository modeloRepository, MarcaRepository marcaRepository) {
        this.modeloRepository = modeloRepository;
        this.marcaRepository = marcaRepository;
    }

    public List<Modelo> buscar(Long marcaId) {
        if (marcaId != null) {
            return modeloRepository.findByMarca_Id(marcaId);
        }
        return modeloRepository.findAll();
    }

    public Modelo criar(Modelo modelo) {
        if (modelo == null || modelo.getNome() == null) {
            throw new RuntimeException("Nome do modelo não informado.");
        }

        String nome = modelo.getNome().trim();

        if (nome.isEmpty()) {
            throw new RuntimeException("nome do modelo nao pode ficar em branco");
        }

        if (modelo.getMarca() == null || modelo.getMarca().getId() == null) {
            throw new RuntimeException("informe a marca do modelo");
        }

        Marca marca = marcaRepository.findById(modelo.getMarca().getId())
                .orElseThrow(() -> new RuntimeException("Marca não encontrada."));

        if (modeloRepository.existsByNomeIgnoreCaseAndMarca_Id(nome, marca.getId())) {
            throw new RuntimeException("modelo ja está cadastrado para essa marca");
        }

        modelo.setNome(nome);
        modelo.setMarca(marca);

        return modeloRepository.save(modelo);
    }
}