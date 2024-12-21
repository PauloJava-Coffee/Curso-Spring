/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.repository;

import io.github.paulojava_coffee.libraryapi.model.Livro;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author barbo
 */
public interface LivroRepository extends JpaRepository<Livro,UUID> {
    
}
