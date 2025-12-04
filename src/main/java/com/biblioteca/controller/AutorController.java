package com.biblioteca.controller;

import com.biblioteca.model.Autor;
import com.biblioteca.service.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> listarTodos() {
        return autorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarPorId(@PathVariable Long id) {
        Autor autor = autorService.buscarPorId(id);
        return (autor != null) ? ResponseEntity.ok(autor) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Autor> criar(@RequestBody Autor autor) {
        Autor salvo = autorService.salvar(autor);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> atualizar(@PathVariable Long id, @RequestBody Autor dados) {
        Autor existente = autorService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        existente.setNome(dados.getNome());
        existente.setNacionalidade(dados.getNacionalidade());
        Autor atualizado = autorService.salvar(existente);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean deletou = autorService.deletar(id);
        return deletou ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
