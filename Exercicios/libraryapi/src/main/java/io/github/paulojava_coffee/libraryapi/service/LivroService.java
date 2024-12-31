/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.service;

import io.github.paulojava_coffee.libraryapi.model.Livro;
import io.github.paulojava_coffee.libraryapi.repository.LivroRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author santa
 */
@Service
@RequiredArgsConstructor
public class LivroService {
    
    private final LivroRepository repository;
    
    public void salvarLivro(Livro livro){
       repository.save(livro);
    }
    
    public Optional<Livro> obterPorId(String id){
        
        return repository.findById(UUID.fromString(id));
    }
}
