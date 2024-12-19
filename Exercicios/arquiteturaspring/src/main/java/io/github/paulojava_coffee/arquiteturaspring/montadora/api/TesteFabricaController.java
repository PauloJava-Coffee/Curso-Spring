/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.arquiteturaspring.montadora.api;

import io.github.paulojava_coffee.arquiteturaspring.montadora.Chave;
import io.github.paulojava_coffee.arquiteturaspring.montadora.HondaHRV;
import io.github.paulojava_coffee.arquiteturaspring.montadora.Motor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author barbo
 */
@RestController
@RequestMapping("/carros")
public class TesteFabricaController {

    @Autowired
    @Turbo
    Motor motor;

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave) {
        var carro = new HondaHRV(motor);
        return carro.darIgnicao(chave);
    }
}
