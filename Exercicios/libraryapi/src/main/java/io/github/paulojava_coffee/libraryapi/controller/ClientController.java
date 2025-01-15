/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.controller;

import io.github.paulojava_coffee.libraryapi.model.Client;
import io.github.paulojava_coffee.libraryapi.service.ClientService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author santa
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("clients")
public class ClientController {
    
    private final PasswordEncoder encoder;
    private final ClientService service;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("permitAll()")
    public void salvar(@RequestBody Client entity) {
        entity.setClientSecret(encoder.encode(entity.getClientSecret()));
        service.salvar(entity);
    }
    
    @GetMapping
    public List<Client> pesquisa(){
        return service.pesquisa();
    }
}
