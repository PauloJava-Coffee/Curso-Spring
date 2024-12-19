/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.arquiteturaspring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author barbo
 */
@Component
public class ExemploValue {

    @Value("${spring.application.name}")
    private String variavel;

    public void imprimirVariavel() {
        System.out.println(variavel);
    }
}
