/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.repository;

import io.github.paulojava_coffee.libraryapi.dto.AutorDTO;
import io.github.paulojava_coffee.libraryapi.model.Autor;
import io.github.paulojava_coffee.libraryapi.model.Usuario;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author barbo
 */
public interface AutorRepository extends JpaRepository<Autor, UUID> {

   /* List<AutorDTO> findByNome(String nome);

    List<AutorDTO> findByNacionalidade(String nacionalidade);*/

    List<AutorDTO> findByNomeAndNacionalidade(String nacionalidade, String nome);

    //Select * from autores where nome = ? or nacionalidade = ?
    List<AutorDTO> findByNomeOrNacionalidade(String nome, String nacionalidade);
    
    Optional<Autor> findByNomeAndDataNascimentoAndNacionalidade(
     String nome, LocalDate dataNascimento, String nacionalidade
    );
    
    /*
    @Transactional
    @Modifying
    @Query("update  Autor set usuario = :i")
     void limpar(@Param("i") Usuario i);*/
    
}
