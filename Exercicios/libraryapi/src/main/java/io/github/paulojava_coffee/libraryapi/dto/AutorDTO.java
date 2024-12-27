/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.dto;

import io.github.paulojava_coffee.libraryapi.model.Autor;
import java.time.LocalDate;

/**
 *
 * @author santa
 */
//DATA TRANSFER OBJECT

public record AutorDTO(
        String nome,
        LocalDate dataNascimento, 
        String nacionalidade) {

    public Autor mapearParaAutor(){
        Autor autor = new Autor();
        autor.setNome(nome);
        autor.setNacionalidade(nacionalidade);
        autor.setDataNascimento(dataNascimento);
        
        return autor;
    }
}
