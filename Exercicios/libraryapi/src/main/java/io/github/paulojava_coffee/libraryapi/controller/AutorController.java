/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.controller;

import io.github.paulojava_coffee.libraryapi.dto.AutorDTO;
import io.github.paulojava_coffee.libraryapi.model.Autor;
import io.github.paulojava_coffee.libraryapi.service.AutorService;
import java.net.URI;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


/**
 *
 * @author santa
 */
@RestController
@RequestMapping("autores")
public class AutorController {

    private final AutorService service;
    
    public AutorController(AutorService service){
        this.service = service;
        
    }
    
    
    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody AutorDTO autor){
        var  autorEntidade = autor.mapearParaAutor();
        service.salvar(autorEntidade);
        
       URI location =  ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(autorEntidade.getId())
                .toUri();
                        
        return ResponseEntity.created(location).build();
    }
    
   @GetMapping
   public List<Autor> buscarAutor(){
      return service.buscarAutores(); 
   }
}
