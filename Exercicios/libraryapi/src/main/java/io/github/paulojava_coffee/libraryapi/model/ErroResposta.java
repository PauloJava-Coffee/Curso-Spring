/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.model;

import java.util.List;
import org.springframework.http.HttpStatus;

/**
 *
 * @author santa
 */
public record ErroResposta(int status, String mensagem, List<ErroCampo> erro) {

    public static ErroResposta respostaPadrao(String mensagem){
       return new ErroResposta(HttpStatus.BAD_REQUEST.value(), mensagem, List.of()); 
    }
    
     public static ErroResposta conflito(String mensagem){
       return new ErroResposta(HttpStatus.CONFLICT.value(), mensagem, List.of()); 
    }
}
