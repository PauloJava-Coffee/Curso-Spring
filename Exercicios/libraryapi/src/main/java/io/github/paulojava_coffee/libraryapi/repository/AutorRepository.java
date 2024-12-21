/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.repository;

import io.github.paulojava_coffee.libraryapi.model.Autor;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author barbo
 */
public interface AutorRepository extends JpaRepository<Autor,UUID>{
    
}
