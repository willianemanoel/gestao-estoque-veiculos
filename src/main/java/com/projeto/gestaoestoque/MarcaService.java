package com.projeto.gestaoestoque;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    private final MarcaRepository repository;

    public MarcaService(MarcaRepository repository) {
        this.repository = repository;
    }

    public List<Marca> buscarTodas() {
        return repository.findAll();
    }

    public Marca criar(Marca marca) {
        if (marca == null || marca.getNome() == null) {
            throw new RuntimeException("informe o nome da marca");
        }

        String nome = marca.getNome().trim();

        if (nome.isEmpty()) {
            throw new RuntimeException("nome da marca nao pode ficar em branco");
        }

        if (repository.existsByNomeIgnoreCase(nome)) {
            throw new RuntimeException("ja existe marca com esse nome");
        }

        marca.setNome(nome);
        return repository.save(marca);
    }
}