package com.biblioteca.service;

import com.biblioteca.model.Editora;
import com.biblioteca.repository.EditoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditoraService {

    private final EditoraRepository editoraRepository;

    // Injeção de dependência via construtor (boa prática no Spring)
    public EditoraService(EditoraRepository editoraRepository) {
        this.editoraRepository = editoraRepository;
    }

    /**
     * Retorna todas as editoras cadastradas.
     */
    public List<Editora> listarTodas() {
        return editoraRepository.findAll();
    }

    /**
     * Busca uma editora pelo ID.
     * Retorna Optional para evitar NullPointerException.
     */
    public Optional<Editora> buscarPorId(Long id) {
        return editoraRepository.findById(id);
    }

    /**
     * Cadastra uma nova editora.
     */
    public Editora salvar(Editora editora) {
        return editoraRepository.save(editora);
    }

    /**
     * Atualiza uma editora existente, se ela existir.
     */
    public Optional<Editora> atualizar(Long id, Editora dadosAtualizados) {
        return editoraRepository.findById(id).map(editora -> {
            editora.setNome(dadosAtualizados.getNome());
            editora.setCidade(dadosAtualizados.getCidade());
            return editoraRepository.save(editora);
        });
    }

    /**
     * Remove uma editora pelo ID.
     */
    public boolean deletar(Long id) {
        if (editoraRepository.existsById(id)) {
            editoraRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
