/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.repository;

import io.github.paulojava_coffee.libraryapi.model.Autor;
import io.github.paulojava_coffee.libraryapi.model.GeneroLivro;
import io.github.paulojava_coffee.libraryapi.model.Livro;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author barbo
 */
public interface LivroRepository extends JpaRepository<Livro, UUID> , JpaSpecificationExecutor<Livro> {

   
    //Query method
    List<Livro> findByAutor(Autor autor);

    //Select * from livro where titulo = ?
    List<Livro> findByTitulo(String titulo);

    //Select * from livro where isbn = ?
    List<Livro> findByIsbn(String titulo);

    //Select * from livro where titulo = ? and preco = ?
    List<Livro> findByTituloAndPreco(String titulo, BigDecimal preco);

    //Select * from livro where titulo = ? or preco = ?
    List<Livro> findByTituloOrPreco(String titulo, BigDecimal preco);

    //Select * from Livro where data_publicacao between ? and ?
    List<Livro> findByDataPublicacaoBetween(LocalDate inicil, LocalDate fim);

    // Select l.* from livro as l order by l.titulo
    @Query("Select l from Livro l order by l.titulo")
    List<Livro> listarTodos();

    @Query("Select a from Livro l join l.autor a ")
    List<Autor> listarAutores();

    @Query("Select distinct l.titulo from Livro l")
    List<String> listarTitulosDistintos();

    //Namaed parameters -> parametros nomeados
    @Query(
            """
            Select l.genero from Livro l join l.autor a
            where a.nacionalidade = 'Uru' order by 
            l.genero
            """
    )
    List<String> listarGeneroOnNacionalidade();

    //Namaed parameters -> parametros nomeados
    @Query("Select l from Livro l where l.genero = :genero order by :filtro")
    List<Livro> findByGenero(
            @Param("genero") GeneroLivro genero,
            @Param("filtro") String filtro);

    //Positional parameters -
    @Query("Select l from Livro l where l.genero = ?1 order by ?2")
    List<Livro> findByGeneroPositional(GeneroLivro genero, String filtro);

    @Modifying
    @Transactional
    
    @Query("delete from Livro l where l.genero = ?1")
    void deleteByGenero(GeneroLivro genero);

    @Modifying
    @Transactional
    @Query("Update Livro set dataPublicacao = ?1")
    void updadeDataPublicacao(LocalDate novaData);
    
     boolean existsByAutor(Autor autor);
}
