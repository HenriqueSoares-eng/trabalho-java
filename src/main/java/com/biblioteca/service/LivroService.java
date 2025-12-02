package com.biblioteca.service;

import com.biblioteca.model.Autor;
import com.biblioteca.model.Editora;
import com.biblioteca.model.Livro;
import com.biblioteca.repository.AutorRepository;
import com.biblioteca.repository.EditoraRepository;
import com.biblioteca.repository.LivroRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;
    private final EditoraRepository editoraRepository;

    // Injeção de dependência via construtor
    public LivroService(LivroRepository livroRepository,
                        AutorRepository autorRepository,
                        EditoraRepository editoraRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.editoraRepository = editoraRepository;
    }

    /**
     * Lista todos os livros cadastrados.
     */
    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    /**
     * Busca um livro pelo ID.
     */
    public Optional<Livro> buscarPorId(Long id) {
        return livroRepository.findById(id);
    }

    /**
     * Cria um novo livro, associando um autor e uma editora.
     */
    public Optional<Livro> criar(Livro livro, Long autorId, Long editoraId) {

        // Verifica se o Autor existe
        Optional<Autor> autor = autorRepository.findById(autorId);
        if (autor.isEmpty()) {
            return Optional.empty();
        }

        // Verifica se a Editora existe
        Optional<Editora> editora = editoraRepository.findById(editoraId);
        if (editora.isEmpty()) {
            return Optional.empty();
        }

        livro.setAutor(autor.get());
        livro.setEditora(editora.get());

        Livro livroSalvo = livroRepository.save(livro);
        return Optional.of(livroSalvo);
    }

    /**
     * Atualiza um livro existente.
     */
    public Optional<Livro> atualizar(Long id, Livro dadosAtualizados,
                                     Long novoAutorId, Long novaEditoraId) {

        return livroRepository.findById(id).map(livro -> {

            livro.setTitulo(dadosAtualizados.getTitulo());
            livro.setAnoPublicacao(dadosAtualizados.getAnoPublicacao());

            // Se um novo autor foi informado
            if (novoAutorId != null) {
                autorRepository.findById(novoAutorId).ifPresent(autor -> livro.setAutor(autor));
            }

            // Se uma nova editora foi informada
            if (novaEditoraId != null) {
                editoraRepository.findById(novaEditoraId).ifPresent(editora -> livro.setEditora(editora));
            }

            return livroRepository.save(livro);
        });
    }

    /**
     * Deleta um livro pelo ID.
     */
    public boolean deletar(Long id) {
        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
