package com.biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "editora")
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_editora;

    @Column(nullable = false, length = 120)
    private String nome;

    @Column(length = 80)
    private String cidade;

    public Editora() {}

    // GETTERS E SETTERS
    public Long getId_editora() { return id_editora; }
    public void setId_editora(Long id_editora) { this.id_editora = id_editora; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
}
