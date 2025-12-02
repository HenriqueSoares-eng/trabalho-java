package com.biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_autor;

    @Column(nullable = false, length = 120)
    private String nome;

    @Column(length = 80)
    private String nacionalidade;

    public Autor() {}

    // GETTERS E SETTERS
    public Long getId_autor() { return id_autor; }
    public void setId_autor(Long id_autor) { this.id_autor = id_autor; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getNacionalidade() { return nacionalidade; }
    public void setNacionalidade(String nacionalidade) { this.nacionalidade = nacionalidade; }
}
