package com.projeto.gestaoestoque;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    List<Modelo> findByMarca_Id(Long marcaId);

    List<Modelo> findByNomeContainingIgnoreCase(String nome);

    boolean existsByNomeIgnoreCaseAndMarca_Id(String nome, Long marcaId);

    Optional<Modelo> findByNomeIgnoreCaseAndMarca_Id(String nome, Long marcaId);
}