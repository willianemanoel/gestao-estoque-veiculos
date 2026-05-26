package com.projeto.gestaoestoque;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modelos")
@CrossOrigin(origins = "*")
public class ModeloController {

    private final ModeloService service;

    public ModeloController(ModeloService service) {
        this.service = service;
    }

    @GetMapping
    public List<Modelo> buscar(@RequestParam(required = false) Long marcaId) {
        return service.buscar(marcaId);
    }

    @PostMapping
    public Modelo criar(@RequestBody Modelo modelo) {
        return service.criar(modelo);
    }
}