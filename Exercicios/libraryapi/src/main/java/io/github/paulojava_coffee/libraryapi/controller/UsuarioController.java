/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.controller;

import io.github.paulojava_coffee.libraryapi.dto.UsuarioDTO;
import io.github.paulojava_coffee.libraryapi.mappers.UsuarioMapper;
import io.github.paulojava_coffee.libraryapi.model.Usuario;
import io.github.paulojava_coffee.libraryapi.repository.AutorRepository;
import io.github.paulojava_coffee.libraryapi.repository.LivroRepository;
import io.github.paulojava_coffee.libraryapi.service.UsuarioService;
import io.github.paulojava_coffee.libraryapi.validator.UsuarioValidator;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author santa
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioService service;
    private final UsuarioMapper mapper;
    private final UsuarioValidator validator;

    
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("permitAll")
    public void salvar(@RequestBody @Valid UsuarioDTO dto) {
        validator.validar(dto);
        var usuario = mapper.toEntity(dto);
        service.salvar(usuario);
    }

    @GetMapping
    @PreAuthorize("permitAll")
    public List<Usuario> findAll() {
        return service.findAll();
    }

    /* @DeleteMapping
    public void deletar(){
        ar.limpar(null);
        lr.limpar(null);
        service.deletAll();
    }*/
}
