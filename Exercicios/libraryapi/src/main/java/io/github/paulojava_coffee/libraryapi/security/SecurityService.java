/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.security;

import io.github.paulojava_coffee.libraryapi.model.Usuario;
import io.github.paulojava_coffee.libraryapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 *
 * @author santa
 */
@Component
public class SecurityService {
   
    
    public Usuario obterUsuarioLogado(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();  
        if(authentication instanceof CustomAuthentication custmAuth){
            return custmAuth.getUsuario();
        }
        
        return null;
    }
}
