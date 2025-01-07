/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.service;

import io.github.paulojava_coffee.libraryapi.model.GeneroLivro;
import io.github.paulojava_coffee.libraryapi.model.Livro;
import io.github.paulojava_coffee.libraryapi.repository.LivroRepository;
import io.github.paulojava_coffee.libraryapi.repository.specs.LivroSpecs;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import static io.github.paulojava_coffee.libraryapi.repository.specs.LivroSpecs.*;
import io.github.paulojava_coffee.libraryapi.security.SecurityService;
import io.github.paulojava_coffee.libraryapi.validator.LivroValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author santa
 */
@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository repository;
    private final LivroValidator validator;
    private final SecurityService securityService;

    public void salvarLivro(Livro livro) {
        validator.validar(livro);
        livro.setUsuario(securityService.obterUsuarioLogado());
        repository.save(livro);
    }

    public Optional<Livro> obterPorId(String id) {
        return repository.findById(UUID.fromString(id));
    }

    public void deletar(Livro livro) {
        repository.delete(livro);
    }

    public Page<Livro> pesquisa(String isbn, String titulo, String nomeAutor, GeneroLivro genero,
            Integer anoPublicacao, Integer pagina, Integer tamanhoPagina
    ) {

        //SELECT * FROM LIVRO WHERE 0 = 0
        Specification<Livro> specs = Specification.where((root, query, cb) -> cb.conjunction());

        if (isbn != null) {
            //QUERY = QUERY AND ISBN = :?
            specs = specs.and(LivroSpecs.isbnEqual(isbn));
        }
        if (titulo != null) {
            //UTILIZANDO MÉTODO ESTÁTICO  IMPORTADO DE LivroSpecs
            //QUERY = QUERY AND titulo = :?
            specs = specs.and(tituloLike(titulo));
        }
        if (genero != null) {
            //QUERY = QUERY AND genero = :?
            specs = specs.and(LivroSpecs.generoEqual(genero));
        }
        if (anoPublicacao != null) {
            //UTILIZANDO MÉTODO ESTÁTICO  IMPORTADO DE LivroSpecs
            specs = specs.and(anoPublicacaoEqual(anoPublicacao));
        }
        if (nomeAutor != null) {
            specs = specs.and(nomeAutorLike(nomeAutor));
        }

        Pageable pageRequest = PageRequest.of(pagina, tamanhoPagina);
                
        return repository.findAll(specs, pageRequest);
    }

    public void atualizarLivro(Livro livro) {
        if (livro.getId() == null) {
            throw new IllegalArgumentException("Para atualizar, é necessário que o livro já esteja salvo na base de dados");
        }
        validator.validar(livro);
        repository.save(livro);
    }

}
