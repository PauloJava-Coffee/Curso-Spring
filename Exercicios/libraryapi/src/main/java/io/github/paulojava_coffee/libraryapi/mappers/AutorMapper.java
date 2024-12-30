/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.mappers;

import io.github.paulojava_coffee.libraryapi.dto.AutorDTO;
import io.github.paulojava_coffee.libraryapi.model.Autor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author santa
 */
@Mapper(componentModel = "spring")
public interface AutorMapper {
    /* USADO PARA MAPEAR QUANDO O NOME DE UM 
     * ATRIBUTO ESTÁ DIFERENTE NO DTO 
    * */
    @Mapping(source = "nome", target = "nome") 
    Autor toEntity(AutorDTO dto);
    
    AutorDTO toDTO(Autor entity);
}
