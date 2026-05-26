package com.projeto.gestaoestoque;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
@CrossOrigin(origins = "*")
public class MarcaController {

    private final MarcaService service;

    public MarcaController(MarcaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Marca> buscarTodas() {
        return service.buscarTodas();
    }

    @PostMapping
    public Marca criar(@RequestBody Marca marca) {
        return service.criar(marca);
    }
}