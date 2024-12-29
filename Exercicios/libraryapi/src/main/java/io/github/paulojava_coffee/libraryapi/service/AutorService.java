/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.service;

import io.github.paulojava_coffee.libraryapi.dto.AutorDTO;
import io.github.paulojava_coffee.libraryapi.exceptios.OperacaoNaoPermitidaException;
import io.github.paulojava_coffee.libraryapi.model.Autor;
import io.github.paulojava_coffee.libraryapi.repository.AutorRepository;
import io.github.paulojava_coffee.libraryapi.repository.LivroRepository;
import io.github.paulojava_coffee.libraryapi.validator.AutorValidador;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author santa
 */
@Service
public class AutorService {

    private final AutorRepository repository;
    private final LivroRepository livroRepository;
    private final AutorValidador validador;

    public AutorService(AutorRepository repository, AutorValidador validador, LivroRepository livroRepository) {
        this.repository = repository;
        this.livroRepository = livroRepository;
        this.validador = validador;
        
    }

    public Autor salvar(Autor autor) {
        validador.validar(autor);
        return repository.save(autor);
    }

    public void atualizar(Autor autor) {

        if (autor.getId() == null) {
            throw new IllegalArgumentException("Erro");
        }

        validador.validar(autor);
        repository.save(autor);
    }

    public Optional<Autor> findById(UUID id) {

        return repository.findById(id);
    }

    /*
     Método deletar Autor
     */
    public Void deletarAutor(Autor autor) {
        if(possuiLivro(autor)){
           throw new OperacaoNaoPermitidaException("Não é possível deletar um autor que "
                   + "possui livros");
        }
        repository.delete(autor);

        return null;

    }

    //MÉTODO NÃO PERSONALIZADO PARA BUSCAR  AUTORES
    public ResponseEntity<List<AutorDTO>> buscarAutores(String nome, String nacionalidade) {

        if (nome != null ^ nacionalidade != null) {
            List<AutorDTO> lista = repository.findByNomeOrNacionalidade(nome, nacionalidade);
            return ResponseEntity.ok(lista);
        }
        if (nome != null && nacionalidade != null) {
            List<AutorDTO> lista = repository.findByNomeAndNacionalidade(nome, nacionalidade);
            return ResponseEntity.ok(lista);

        }

        return ResponseEntity.ok(repository.findAll().stream()
                .map(x -> new AutorDTO(x.getId(), x.getNome(), x.getDataNascimento(),
                x.getNacionalidade())).collect(Collectors.toList()));
    }

    public List<AutorDTO> findByExemplo(String nome, String nacionalidade) {
        var autor = new Autor();

        autor.setNome(nome);
        autor.setNacionalidade(nacionalidade);

        ExampleMatcher matcher = ExampleMatcher.
                matching()
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(StringMatcher.CONTAINING);

        Example<Autor> autorExemplo = Example.of(autor, matcher);

        return repository.findAll(autorExemplo).stream().map(x
                -> new AutorDTO(x.getId(), x.getNome(), x.getDataNascimento(),
                        x.getNacionalidade())).collect(Collectors.toList());
    }

    public boolean possuiLivro(Autor autor) {
        return livroRepository.existsByAutor(autor);
    }
}
