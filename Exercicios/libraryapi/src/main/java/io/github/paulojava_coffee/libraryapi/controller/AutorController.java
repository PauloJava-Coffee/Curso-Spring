/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.controller;

import io.github.paulojava_coffee.libraryapi.dto.AutorDTO;
import io.github.paulojava_coffee.libraryapi.exceptios.OperacaoNaoPermitidaException;
import io.github.paulojava_coffee.libraryapi.exceptios.RegistroDuplicadoException;
import io.github.paulojava_coffee.libraryapi.mappers.AutorMapper;
import io.github.paulojava_coffee.libraryapi.model.Autor;
import io.github.paulojava_coffee.libraryapi.model.ErroResposta;
import io.github.paulojava_coffee.libraryapi.security.SecurityService;
import io.github.paulojava_coffee.libraryapi.service.AutorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author santa
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("autores")
@Tag(name = "Autor")
@Slf4j
public class AutorController implements GenericController {

    private final AutorService service;
    private final AutorMapper mapper;
    private final SecurityService securityService;

    @PostMapping
    @PreAuthorize("hasAnyRole('GERENTE')")
    @Operation(summary = "Salvar", description = "Cadastrar novo autor")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Cadastrado com sucesso"),
        @ApiResponse(responseCode = "422", description = "Erro de validação"),
        @ApiResponse(responseCode = "409", description = "Autor ja cadastrado")
    })
    public ResponseEntity<Object> salvar(@RequestBody @Valid AutorDTO dto, Authentication athentication) {
        
        log.info("Novo autor: {}", dto.nome());
        /*  
        UserDetails usuarioLogado = (UserDetails) athentication.getPrincipal();
        Usuario usuatio = securityService.obterUsuarioLogado();*/
        var autor = mapper.toEntity(dto);
        service.salvar(autor);
        URI location = gerarHeaderLocation(autor.getId());

        return ResponseEntity.created(location).build();

    }

    @GetMapping("{id}")
    @PreAuthorize("hasAnyRole('GERENTE','OPERADOR')")
    @Operation(summary = "Obter detalhes", description = "Consultar autor por ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Encontrado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Autor não encotrado")
    })
    public ResponseEntity<AutorDTO> obterDetalhes(@PathVariable("id") String id) {
        var idAutor = UUID.fromString(id);
        Optional<Autor> autorOptional = service.findById(idAutor);

        return service.findById(idAutor).map(x -> {
            return ResponseEntity.ok(mapper.toDTO(x));
        }).orElseGet(() -> ResponseEntity.notFound().build());

        /*
        if (autorOptional.isPresent()) {
            Autor autor = autorOptional.get();
            AutorDTO dto = mapper.toDTO(autorOptional.get());
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }*/
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('GERENTE')")
    @Operation(summary = "Deletar", description = "Deletar por ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Deletado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Autor possui livro cadastrado"),
        @ApiResponse(responseCode = "404", description = "Autor não encotrado"),})
    public ResponseEntity<Object> deletarAutor(@PathVariable String id) {
        log.info("Deleetando autor de ID: {}", id);
        try {
            var optionalAutor = service.findById(UUID.fromString(id));
            if (optionalAutor.isPresent()) {
                service.deletarAutor(optionalAutor.get());
            }
            return ResponseEntity.noContent().build();
        } catch (OperacaoNaoPermitidaException erro) {
            var erroDTO = ErroResposta.conflito(erro.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('GERENTE','OPERADOR')")
    @Operation(summary = "Pesquisar", description = "Pesquisa com parâmetros")
    @ApiResponse(responseCode = "200", description = "Pesquisa realizada com sucesso")
    public ResponseEntity<List<AutorDTO>> pesquisar(@RequestParam(value = "nome",
            required = false) String nome, @RequestParam(value = "nacionalidade",
            required = false) String nacinalidade) {

        /*log.trace("Pesquisa autores");
        log.debug("Pesquisa autores");
        log.info("Pesquisa autores");
        log.warn("Pesquisa autores");
        log.error("Pesquisa autores");*/

        return ResponseEntity.ok(service.findByExemplo(nome, nacinalidade));
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('GERENTE')")
    @Operation(summary = "Atualizar", description = "Atualizar dados cadastrais")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Atualização realizada com succeso"),
        @ApiResponse(responseCode = "209", description = "Credenciais já estão em uso"),
        @ApiResponse(responseCode = "404", description = "Autor não existe")
    })
    public ResponseEntity<Object> atualizar(@PathVariable("id") String id, @RequestBody @Valid AutorDTO dto) {
        try {
            var idAutor = UUID.fromString(id);
            Optional<Autor> result = service.findById(idAutor);
            if (result.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            var autor = result.get();
            autor.setNome(dto.nome());
            autor.setNacionalidade(dto.nacionalidade());
            autor.setDataNascimento(dto.dataNascimento());
            service.atualizar(autor);
            return ResponseEntity.noContent().build();
        } catch (RegistroDuplicadoException erro) {
            var erroDTO = ErroResposta.conflito(erro.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }
    }

}
