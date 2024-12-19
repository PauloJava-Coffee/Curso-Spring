/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

/**
 *
 * @author barbo
 */
@Component
public class MailSender {
    public void enviar(String mensagem){
        System.out.println("Enviado email: " + mensagem);
    }
    
}
