package com.projeto.gestaoestoque;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    @Query("""
        SELECT v
        FROM Veiculo v
        WHERE (:modelo IS NULL OR
               LOWER(v.modelo.nome) LIKE LOWER(CONCAT('%', :modelo, '%')))
          AND (:marca IS NULL OR
               LOWER(v.modelo.marca.nome) LIKE LOWER(CONCAT('%', :marca, '%')))
          AND (:ano IS NULL OR v.ano = :ano)
          AND (:precoMax IS NULL OR v.preco <= :precoMax)
          AND (:status IS NULL OR LOWER(v.status) = LOWER(:status))
        ORDER BY v.id DESC
    """)
    List<Veiculo> buscarComFiltros(
            @Param("modelo") String modelo,
            @Param("marca") String marca,
            @Param("ano") Integer ano,
            @Param("precoMax") Double precoMax,
            @Param("status") String status
    );
}