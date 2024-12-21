/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.test;

import io.github.paulojava_coffee.libraryapi.model.Autor;
import io.github.paulojava_coffee.libraryapi.repository.AutorRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author barbo
 */
@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    @Test
    public void salvarTeste() {

        Autor autor = new Autor();
        autor.setNome("Maria");
        autor.setNacionalidade("BR");
        autor.setDataNascimento(LocalDate.of(2000, 8, 15));

        var autorSalvo = repository.save(autor);

        System.out.println("Autor Salvo: " + autorSalvo);

    }

    @Test
    public void atualizartest() {
        var id = UUID.fromString("2ff06e28-fc53-4255-a0f8-82cf241c59ee");

        Optional<Autor> possivelAutor = repository.findById(id);

        if (possivelAutor.isPresent()) {
            Autor autor = possivelAutor.get();

            autor.setDataNascimento(LocalDate.of(1981, 12, 19));
            repository.save(autor);
            System.out.println("Encontrado: " + autor);
        }
    }

    @Test
    public void listarTest() {
        List<Autor> autores = repository.findAll();
        autores.forEach(System.out::println);
    }

    @Test
    public void countTest() {
        System.out.println("Quantidade de autores: " + repository.count());
    }

    @Test
    public void deletePorIdTest() {
        var id = UUID.fromString("2ff06e28-fc53-4255-a0f8-82cf241c59ee");
        
        repository.deleteById(id);
    }
    
    @Test
    public void deleteTest() {
        var id = UUID.fromString("a2b6f391-2124-4659-b6a8-9ef64f4c11fb");
        var maria = repository.findById(id).get();
        repository.delete(maria);
    }
}
