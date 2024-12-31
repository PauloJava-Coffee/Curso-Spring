/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.mappers;

import io.github.paulojava_coffee.libraryapi.dto.CadastroLivroDTO;
import io.github.paulojava_coffee.libraryapi.dto.ResultadoPesquisaLivroDTO;
import io.github.paulojava_coffee.libraryapi.model.Livro;
import io.github.paulojava_coffee.libraryapi.repository.AutorRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author santa
 */
@Mapper(componentModel = "spring", uses = AutorMapper.class)
public abstract class LivroMapper {
    
    @Autowired
    AutorRepository autorRepository;
    
    @Mapping(target = "autor", expression = "java( autorRepository.findById(dto.idAutor()).orElse(null))")
    public abstract Livro toEntity(CadastroLivroDTO dto);
    
    public abstract ResultadoPesquisaLivroDTO toDTO(Livro livro);
    
    
}
