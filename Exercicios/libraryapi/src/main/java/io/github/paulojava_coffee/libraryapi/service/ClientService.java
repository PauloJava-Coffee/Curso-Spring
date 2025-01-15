/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.service;

import io.github.paulojava_coffee.libraryapi.model.Client;
import io.github.paulojava_coffee.libraryapi.repository.ClientRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author santa
 */
@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository repository;

    public void salvar(Client entity) {
        repository.save(entity);
    }
    
    public Client obterPorClientId(String clientId){
        return repository.findByClientId(clientId);
    }
    
    public List<Client> pesquisa(){
        return repository.findAll();
    }
}
