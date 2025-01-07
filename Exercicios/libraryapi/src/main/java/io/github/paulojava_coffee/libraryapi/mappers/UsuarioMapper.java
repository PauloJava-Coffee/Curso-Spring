/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.mappers;

import io.github.paulojava_coffee.libraryapi.dto.UsuarioDTO;
import io.github.paulojava_coffee.libraryapi.model.Usuario;
import org.mapstruct.Mapper;

/**
 *
 * @author santa
 */
@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario toEntity(UsuarioDTO dto);
    UsuarioDTO toDTO(Usuario usuario);
}
