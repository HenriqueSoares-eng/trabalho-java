package com.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.biblioteca.model.Autor;
import com.biblioteca.repository.AutorRepository;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    // Injeção de dependência pelo construtor (boa prática)
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    /**
     * Retorna todos os autores cadastrados.
     */
    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    /**
     * Busca um autor pelo ID.
     */
    public Autor buscarPorId(Long id) {
        Optional<Autor> autor = autorRepository.findById(id);
        return autor.orElse(null);  // Pode trocar por exceção depois
    }

    /**
     * Salva um novo autor ou atualiza um existente.
     */
    public Autor salvar(Autor autor) {
        return autorRepository.save(autor);
    }

    /**
     * Deleta um autor por ID.
     */
    public boolean deletar(Long id) {
        if (autorRepository.existsById(id)) {
            autorRepository.deleteById(id);
            return true;
        }
        return false; // indica que o autor não existia
    }
}
