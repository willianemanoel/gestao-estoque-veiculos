package com.projeto.gestaoestoque;

import jakarta.persistence.*;

@Entity
@Table(name = "marcas")
public class Marca extends EntidadeBase {

    @Column(nullable = false, unique = true)
    private String nome;

    public Marca() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}