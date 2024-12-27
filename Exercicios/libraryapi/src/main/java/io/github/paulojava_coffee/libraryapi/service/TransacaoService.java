/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.service;

import io.github.paulojava_coffee.libraryapi.model.Autor;
import io.github.paulojava_coffee.libraryapi.model.GeneroLivro;
import io.github.paulojava_coffee.libraryapi.model.Livro;
import io.github.paulojava_coffee.libraryapi.repository.AutorRepository;
import io.github.paulojava_coffee.libraryapi.repository.LivroRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author santa
 */
@Service
public class TransacaoService {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;

    @Transactional
    public void executar() {

        //Criando um autor  que irá ser " salvo em cascata"
        Autor autor = new Autor();
        autor.setNome("Bernabei");
        autor.setNacionalidade("Uru");
        autor.setDataNascimento(LocalDate.of(2000, 8, 15));

        autorRepository.save(autor);

        Livro livro = new Livro();

        livro.setIsbn("1122-7546");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setDataPublicacao(LocalDate.of(1798, 6, 17));
        livro.setGenero(GeneroLivro.ROMANCE);
        livro.setTitulo("Jubileu de ouro");
        livro.setAutor(autor);

        livroRepository.saveAndFlush(livro);

        if ("Bernabei".equals(autor.getNome())) {
            throw new RuntimeException("RollBack");
        }
    }
    
    @Transactional
    public void atualizarSemAtualizar(UUID id,LocalDate novaData){
        
        var livro = livroRepository.findById(id).get();
        livro.setDataPublicacao(novaData);
     
    }
}
