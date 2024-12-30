/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.dto;

import io.github.paulojava_coffee.libraryapi.model.GeneroLivro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import org.hibernate.validator.constraints.ISBN;

/**
 *
 * @author santa
 */
public record CadastroLivroDTO(
        @ISBN
        @NotBlank(message = "Campo obrigatório")
        String isbn,
        
        @NotBlank(message = "Campo obrigatório")
        String titulo,
        
        @NotNull(message = "Campo obrigatório")
        @Past(message = "Data inválida")
        LocalDate dataPublicacao,
        
        GeneroLivro genero,
        
        BigDecimal preco,
        
        @NotNull(message = "Campo obrigatório")
        UUID idAutor) {

}
