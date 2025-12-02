package com.biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_livro;

    @Column(nullable = false, length = 150)
    private String titulo;

    private Integer ano_publicacao;

    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false)
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "id_editora", nullable = false)
    private Editora editora;

    public Livro() {}

    // GETTERS E SETTERS
    public Long getId_livro() { return id_livro; }
    public void setId_livro(Long id_livro) { this.id_livro = id_livro; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Integer getAnoPublicacao() { return ano_publicacao; }
    public void setAnoPublicacao(Integer ano_publicacao) { this.ano_publicacao = ano_publicacao; }

    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) { this.autor = autor; }

    public Editora getEditora() { return editora; }
    public void setEditora(Editora editora) { this.editora = editora; }
}
