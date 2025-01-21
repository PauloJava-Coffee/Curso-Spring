/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.dto;

import io.github.paulojava_coffee.libraryapi.model.Autor;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.beans.BeanUtils;

/**
 *
 * @author santa
 */
//DATA TRANSFER OBJECT
@Schema(name = "Autor")
public record AutorDTO(
        UUID id,
        
        @NotBlank(message = "Campo obrigatório")
        @Size(min = 2, max = 100, message = "Campo fora do tamanho padrão")
        @Schema(name = "nome")
        String nome,
        
        @NotNull(message = "Campo obrigatório")
        @Past(message = "Data inválida")
        @Schema(name = "Data de nascimento")
        LocalDate dataNascimento,
        
        @NotBlank(message = "Campo obrigatório")
        @Size(min = 2, max = 50, message = "Campo fora do tamanho padrão")
        @Schema(name = "Nacionalidade")
        String nacionalidade) {

    public void copiarPropriedade(Autor entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public Autor mapearParaAutor() {
        Autor autor = new Autor();
        autor.setNome(nome);
        autor.setNacionalidade(nacionalidade);
        autor.setDataNascimento(dataNascimento);

        return autor;
    }
}
