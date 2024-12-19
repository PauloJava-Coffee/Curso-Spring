/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.paulojava_coffee.arquiteturaspring.todos;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author barbo
 */
public interface TodoRepository extends JpaRepository<TodoEntity,Integer>{
    boolean existsByDescricao(String descricao);
}
