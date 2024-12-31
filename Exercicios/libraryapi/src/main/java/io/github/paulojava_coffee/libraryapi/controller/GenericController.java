/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.controller;

import java.net.URI;
import java.util.UUID;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author max
 */
public interface GenericController {
    
    default URI gerarHeaderLocation(UUID id){
        return ServletUriComponentsBuilder
               .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
                
    }
}
