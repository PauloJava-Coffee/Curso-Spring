/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.test;

import io.github.paulojava_coffee.libraryapi.model.Autor;
import io.github.paulojava_coffee.libraryapi.model.GeneroLivro;
import io.github.paulojava_coffee.libraryapi.model.Livro;
import io.github.paulojava_coffee.libraryapi.repository.AutorRepository;
import io.github.paulojava_coffee.libraryapi.repository.LivroRepository;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author barbo
 */
@SpringBootTest
public class LivroRepositoryTest {

    @Autowired
    LivroRepository repository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    void salvarTest() {
        Livro livro = new Livro();

        livro.setIsbn("6668-9090");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setDataPublicacao(LocalDate.of(1999, 8, 14));
        livro.setGenero(GeneroLivro.ROMANCE);
        livro.setTitulo("OI");

        Autor autor = autorRepository.findById(UUID.fromString("be17d3f1-ecc4-48b4-bb8c-154319a2007f")).orElse(null);
        livro.setAutor(autor);

        repository.save(livro);

    }

    @Test
    void salvarCascadeTest() {
        Livro livro = new Livro();

        livro.setIsbn("6668-9090");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setDataPublicacao(LocalDate.of(1999, 8, 14));
        livro.setGenero(GeneroLivro.ROMANCE);
        livro.setTitulo("Jardin vermelho");

        //Criando um autor  que irá ser " salvo em cascata"
        Autor autor = new Autor();
        autor.setNome("João");
        autor.setNacionalidade("Uru");
        autor.setDataNascimento(LocalDate.of(2000, 8, 15));

        autorRepository.save(autor);

        livro.setAutor(autor);

        repository.save(livro);
    }

    @Test
    void salvarAutorELivroTest() {
        Livro livro = new Livro();

        livro.setIsbn("6668-9090");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setDataPublicacao(LocalDate.of(1999, 8, 14));
        livro.setGenero(GeneroLivro.ROMANCE);
        livro.setTitulo("OI");

        //Criando um autor  que irá ser " salvo em cascata"
        Autor autor = new Autor();
        autor.setNome("Bernabei");
        autor.setNacionalidade("Uru");
        autor.setDataNascimento(LocalDate.of(2000, 8, 15));

        livro.setAutor(autor);

        repository.save(livro);
    }

    @Test
    void deletarTest() {
        repository.deleteById(UUID.fromString("db9ab415-742e-4770-939f-90d9e48a55b9"));
    }

    @Test
    void alterAltorDoLivro() {
        var livroparaAtualizar = repository.findById(UUID.fromString("aad99e93-94a1-4bc1-9b17-8f17dddcd3ae")).orElse(null);

        UUID idAutor = UUID.fromString("bed2e4bf-47c3-4860-ab94-b7f4423c9ce9");
        Autor autor = autorRepository.findById(idAutor).orElse(null);

        livroparaAtualizar.setAutor(autor);

        repository.save(livroparaAtualizar);

    }

    @Test
    void DeleteTest() {
        Livro livro = repository.findById(UUID.fromString("aad99e93-94a1-4bc1-9b17-8f17dddcd3ae")).orElse(null);

        repository.deleteById(livro.getId());
    }

    @Test
    void DeleteCascade() {
        Livro livro = repository.findById(UUID.fromString("aad99e93-94a1-4bc1-9b17-8f17dddcd3ae")).orElse(null);

        repository.deleteById(livro.getId());
    }
    @Test
    @Transactional
    void buscarLivroTest(){
        UUID id = UUID.fromString("6d056888-f7de-4da0-be0a-35c6e05b9c61");
        Livro livro = repository.findById(id).orElse(null);
        
        System.out.println("Livro: ");
        System.out.println(livro.getTitulo());
        System.out.println("Autor: ");
        System.out.println(livro.getAutor().getNome());
    }

}
