/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.security;

import io.github.paulojava_coffee.libraryapi.model.Usuario;
import io.github.paulojava_coffee.libraryapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author santa
 */
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

     private final UsuarioService service;
     
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario user = service.obterPorLogin(login);
        if(user == null){
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return User.builder()
                .username(user.getLogin())
                .password(user.getSenha())
                .roles(user.getRoles().toArray(new String[user.getRoles().size()]))
                .build();
    }
    
}
