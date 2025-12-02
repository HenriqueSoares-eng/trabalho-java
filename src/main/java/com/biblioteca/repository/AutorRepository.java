package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.biblioteca.model.Autor;

/*
 * Repository responsável pelo acesso aos dados da entidade Autor.
 * 
 * Ao estender JpaRepository, o Spring Data JPA gera automaticamente a 
 * implementação em tempo de execução, fornecendo métodos prontos para
 * operações CRUD (criação, leitura, atualização e remoção), sem que
 * seja necessário escrever código adicional.
 * 
 * Assim, este repository serve como uma camada de abstração entre a 
 * aplicação e o banco de dados, tornando o acesso aos dados mais simples
 * e padronizado.
 */
public interface AutorRepository extends JpaRepository<Autor, Long> {
}