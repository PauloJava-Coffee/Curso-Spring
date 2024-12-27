/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.service;

import io.github.paulojava_coffee.libraryapi.model.Autor;
import io.github.paulojava_coffee.libraryapi.repository.AutorRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 *
 * @author santa
 */
@Service
public class AutorService {
   
   private  AutorRepository repository;
    
    public AutorService(AutorRepository repository){
     this.repository = repository;
    }
    
    public Autor salvar(Autor  autor){
        return repository.save(autor);
    }
    
     public Autor findById(UUID id){
        return repository.findById(id).orElse(null);
    }
    
    public List<Autor> buscarAutores(){
        return repository.findAll();
    }
}
