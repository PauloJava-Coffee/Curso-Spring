/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.exceptios;

import lombok.Getter;

/**
 *
 * @author santa
 */
public class CampoInvalidoException extends RuntimeException {
    
    @Getter
    private String campo;
    
    public CampoInvalidoException(String campo, String mensagem){
        super(mensagem);
        
        this.campo = campo;
    }
}
