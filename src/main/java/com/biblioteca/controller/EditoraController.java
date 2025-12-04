package com.biblioteca.controller;

import com.biblioteca.model.Editora;
import com.biblioteca.service.EditoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

    private final EditoraService editoraService;

    public EditoraController(EditoraService editoraService) {
        this.editoraService = editoraService;
    }

    @GetMapping
    public List<Editora> listarTodas() {
        return editoraService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editora> buscarPorId(@PathVariable Long id) {
        return editoraService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Editora> criar(@RequestBody Editora editora) {
        Editora salvo = editoraService.salvar(editora);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Editora> atualizar(@PathVariable Long id,
                                             @RequestBody Editora dados) {
        return editoraService.atualizar(id, dados)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean deletou = editoraService.deletar(id);
        return deletou ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
