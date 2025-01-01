/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.validator;

import io.github.paulojava_coffee.libraryapi.exceptios.RegistroDuplicadoException;
import io.github.paulojava_coffee.libraryapi.model.Livro;
import io.github.paulojava_coffee.libraryapi.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 *
 * @author santa
 */
@Component
@RequiredArgsConstructor
public class LivroValidator {
    
    private final LivroRepository repository;
    
    public void validar(Livro livro){
      if(existeLivroComIsbn(livro)){
          throw new RegistroDuplicadoException("ISBN já cadastrado");
      }
        
    }
    
    private boolean existeLivroComIsbn(Livro livro){
        var resultado = repository.findByIsbn(livro.getIsbn());
        
        if(livro.getId() == null){
            return  resultado.isPresent();
        }
        
       return resultado.map(Livro::getId)
               .stream()
               .anyMatch(id -> !id.equals(livro.getId()));
               
    }
}
