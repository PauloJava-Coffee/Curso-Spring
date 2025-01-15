/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.repository;

import io.github.paulojava_coffee.libraryapi.model.Client;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author santa
 */
public interface ClientRepository extends JpaRepository<Client, UUID>{

    public Client findByClientId(String clientId);
    
}
