/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.controller;

import io.github.paulojava_coffee.libraryapi.dto.CadastroLivroDTO;
import io.github.paulojava_coffee.libraryapi.exceptios.RegistroDuplicadoException;
import io.github.paulojava_coffee.libraryapi.model.ErroResposta;
import io.github.paulojava_coffee.libraryapi.model.Livro;
import io.github.paulojava_coffee.libraryapi.repository.LivroRepository;
import io.github.paulojava_coffee.libraryapi.service.LivroService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author santa
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("livros")
public class LivroController {
    
    private final LivroService service;
    
    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid CadastroLivroDTO dto){
        try {
            
            return ResponseEntity.ok(dto);
        } catch (RegistroDuplicadoException erro) {
            var erroDTO = ErroResposta.conflito(erro.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }
    }
    
   
    
}
