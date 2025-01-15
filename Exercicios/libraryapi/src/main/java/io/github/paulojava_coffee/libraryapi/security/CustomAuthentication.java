/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.security;

import io.github.paulojava_coffee.libraryapi.model.Usuario;
import java.util.Collection;
import java.util.stream.Collectors;
import javax.security.auth.Subject;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 *
 * @author santa
 */
@RequiredArgsConstructor
public class CustomAuthentication implements Authentication {

    @Getter
    private final Usuario usuario;

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return this.usuario.getRoles().
                stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return this.usuario;
    }

    @Override
    public Object getPrincipal() {
        return this.usuario;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
       
    }

    @Override
    public String getName() {
       return this.usuario.getLogin();
    }

    @Override
    public boolean implies(Subject subject) {
        return Authentication.super.implies(subject); 
    }

}
