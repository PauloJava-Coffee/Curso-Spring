/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.validator;

import io.github.paulojava_coffee.libraryapi.dto.UsuarioDTO;
import io.github.paulojava_coffee.libraryapi.exceptios.RegistroDuplicadoException;
import io.github.paulojava_coffee.libraryapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 *
 * @author santa
 */
@RequiredArgsConstructor
@Component
public class UsuarioValidator {
    
    private final UsuarioService service;
    
    public void validar(UsuarioDTO data){
        String login = data.login();
        String email = data.email();
        if(service.existsByEmail(email)) 
            throw new RegistroDuplicadoException("Este email já esta sendo usado");
        if(service.existsByLogin(login)) 
            throw new RegistroDuplicadoException("Este login já esta sendo usado");     
    }
}
